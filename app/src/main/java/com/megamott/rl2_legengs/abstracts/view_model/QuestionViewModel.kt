package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.QuestionRepoImplHardcore

class QuestionViewModel(state: SavedStateHandle) : ViewModel() {
    private val questionsRepo: QuestionsRepo = QuestionRepoImplHardcore()
    private val savedStateHandle = state
    private val questions = questionsRepo.getQuestions()
    private var questionNumber: Int? = savedStateHandle[QUESTION_NUMBER] ?: 0

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