package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.UserListImplFirebase

class UserListViewModel(state: SavedStateHandle) : ViewModel() {
    private val userListRepo : UserListRepo = UserListImplFirebase()
    private val savedStateHandle = state
    var userListLiveData = MutableLiveData(savedStateHandle[USER_LIST] ?: StringBuilder(""))

    companion object {
        private const val USER_LIST = "users_list"
    }

    fun queryUserList(){
        userListLiveData.value = userListRepo.getUsers()
        savedStateHandle[USER_LIST] = userListLiveData.value
    }
}