package com.megamott.rl2_legengs.abstracts.repo.impl

import com.megamott.rl2_legengs.abstracts.entity.Question
import com.megamott.rl2_legengs.abstracts.repo.QuestionsRepo

class QuestionRepoImplHardcore : QuestionsRepo {

    private val questionsList : MutableList<Question> = ArrayList()

    init {
        questionsList.add(Question(1, "A", "AA", arrayListOf("AAA")))
        questionsList.add(Question(2, "B", "BB", arrayListOf("BBB")))
    }

    override fun getQuestions() : MutableList<Question> {
        return questionsList
    }
}