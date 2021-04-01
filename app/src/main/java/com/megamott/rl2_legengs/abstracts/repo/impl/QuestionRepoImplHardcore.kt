package com.megamott.rl2_legengs.abstracts.repo.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.megamott.rl2_legengs.abstracts.entity.local_data.Question
import com.megamott.rl2_legengs.abstracts.repo.QuestionRepo

class QuestionRepoImplHardcore : QuestionRepo {

    private val questionsList : MutableList<Question> = ArrayList()

    init {
        questionsList.add(Question("A", "AA", "a 1 2 3"))
        questionsList.add(Question("B", "BB", "b 1 2 3"))
    }

    override fun getQuestions() : List<Question> {
        return questionsList
    }

    override fun addQuestion() {
        TODO("Not yet implemented")
    }

}