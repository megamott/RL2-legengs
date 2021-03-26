package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.QuestionRepoImplHardcore

class QuestionViewModel : ViewModel() {
    private val questionsRepo : QuestionsRepo = QuestionRepoImplHardcore()
    var question = MutableLiveData(questionsRepo.getQuestion())

    fun queryNextQuestion() {
        try {
            question.value = questionsRepo.getQuestion()
        } catch (e: NoSuchElementException){
            e.printStackTrace()
        }
    }
}