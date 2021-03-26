package com.megamott.rl2_legengs.abstracts.repo

import com.megamott.rl2_legengs.abstracts.entity.Question

interface QuestionsRepo {
    fun getQuestions() : MutableList<Question>?
}