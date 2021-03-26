package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(state : SavedStateHandle) : ViewModel() {
    // saved state map
    private val savedStateHandle = state
    // every time I create a viewModel, the data in this field comes from the map
    // if map is empty, then 0
    private var countLiveData = MutableLiveData(savedStateHandle[COUNT_KEY] ?: 0)

    companion object {  // static - like in Java
        private const val COUNT_KEY = "count"
    }

    fun getInitialCount() : MutableLiveData<Int> {
        return countLiveData
    }

    fun setCurrentCount() {
        countLiveData.value = countLiveData.value!! + 1
        savedStateHandle[COUNT_KEY] = countLiveData.value // save to map
    }
}