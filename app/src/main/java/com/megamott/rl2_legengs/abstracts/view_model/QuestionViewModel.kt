package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.repo.impl.QuestionRepoImplHardcore
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo

class QuestionViewModel : ViewModel() {
    private val questionsRepo : QuestionsRepo = QuestionRepoImplHardcore()
    private val questions : MutableLiveData<ArrayList<Question>> = questionsRepo.getQuestions()

    fun getQuestions() : LiveData<ArrayList<Question>> {
        return questions
    }
}