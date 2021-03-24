package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private var countLiveData = MutableLiveData<Int>()
    private var clickCount : Int = 0

    fun getInitialCount() : MutableLiveData<Int> {
        countLiveData.value = clickCount
        return countLiveData
    }

    fun setCurrentCount() {
        clickCount++
        countLiveData.value = clickCount
    }

}