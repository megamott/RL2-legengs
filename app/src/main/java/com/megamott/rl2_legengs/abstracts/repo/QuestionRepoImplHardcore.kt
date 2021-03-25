package com.megamott.rl2_legengs.abstracts.repo

import androidx.lifecycle.MutableLiveData
import com.megamott.rl2_legengs.abstracts.entity.Question

class QuestionRepoImplHardcore : QuestionsRepo {
    private val questions = MutableLiveData<ArrayList<Question>>()

    override fun getQuestions() : MutableLiveData<ArrayList<Question>>{
        questions.value = arrayListOf(Question(1, "A", "AA", arrayListOf("AAA")),
                                      Question(2, "B", "BB", arrayListOf("BBB"))
        )
        return questions
    }
}