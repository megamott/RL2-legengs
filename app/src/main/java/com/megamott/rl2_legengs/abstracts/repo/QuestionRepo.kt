package com.megamott.rl2_legengs.abstracts.repo

import androidx.lifecycle.LiveData
import com.megamott.rl2_legengs.abstracts.entity.local_data.Question

interface QuestionRepo {

    fun getQuestions() : List<Question>

    fun addQuestion()
}