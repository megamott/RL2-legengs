package com.megamott.rl2_legengs.abstracts.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.megamott.rl2_legengs.abstracts.entity.local_data.Question
import com.megamott.rl2_legengs.abstracts.entity.local_data.QuestionDatabase
import com.megamott.rl2_legengs.abstracts.repo.QuestionRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.QuestionRepoImplRoom

class QuestionViewModel(application: Application, state: SavedStateHandle) : AndroidViewModel(application) {
    private val questionsRepo: QuestionRepo
    private val savedStateHandle = state
    private val questions : List<Question>?
    private var questionNumber: Int? = savedStateHandle[QUESTION_NUMBER] ?: 0

    init {
        val questionDao = QuestionDatabase.getDatabase(application).questionDao()
        questionsRepo = QuestionRepoImplRoom(questionDao)
//        questionsRepo.addQuestion()
        questions = questionsRepo.getQuestions()
    }

    var questionLiveData = MutableLiveData<Question>(questionNumber?.let { questions?.get(it) })

    companion object {
        private const val QUESTION_NUMBER = "question_number"
    }

    fun queryNextQuestion() {
        if (questions != null) {
            questionNumber = if (questionNumber!! < questions.size - 1) questionNumber?.plus(1) else 0
            savedStateHandle[QUESTION_NUMBER] = questionNumber
            questionLiveData.value = questionNumber?.let { questions[it] }
        }
    }
}