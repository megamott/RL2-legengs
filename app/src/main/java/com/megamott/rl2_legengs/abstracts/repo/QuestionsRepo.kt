package com.megamott.rl2_legengs.abstracts.repo

import androidx.lifecycle.MutableLiveData
import com.megamott.rl2_legengs.abstracts.entity.Question

interface QuestionsRepo {
    fun getQuestions() : MutableLiveData<ArrayList<Question>>
}