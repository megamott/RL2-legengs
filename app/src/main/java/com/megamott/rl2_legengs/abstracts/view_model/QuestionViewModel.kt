package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.QuestionRepoImplHardcore

class QuestionViewModel(state: SavedStateHandle) : ViewModel() {
    private val questionsRepo: QuestionsRepo = QuestionRepoImplHardcore()
    private val savedStateHandle = state
    var questionLiveData =
        MutableLiveData(savedStateHandle[QUESTION] ?: questionsRepo.getQuestion())

    companion object {
        private const val QUESTION = "question"
    }

    fun queryNextQuestion() {
        questionLiveData.value = questionsRepo.getQuestion()
        savedStateHandle[QUESTION] = questionLiveData.value
    }
}