package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(state : SavedStateHandle) : ViewModel() {

    private val savedStateHandle = state // saved state map
    private var countLiveData = MutableLiveData(savedStateHandle[COUNT_KEY] ?: 0)

    companion object {  // static - like in Java
        private val COUNT_KEY = "count"
    }

    fun getInitialCount() : MutableLiveData<Int> {
        return countLiveData
    }

    fun setCurrentCount() {
        countLiveData.value = countLiveData.value!! + 1
        savedStateHandle[COUNT_KEY] = countLiveData.value
    }
}