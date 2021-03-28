package com.megamott.rl2_legengs.abstracts.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.UserListImplFirebase
import java.lang.StringBuilder

class UserListViewModel() : ViewModel() {
    private val userListRepo : UserListRepo = UserListImplFirebase()
    var userListLiveData : MutableLiveData<List<String>> = MutableLiveData()

    init {
        val users = userListRepo.getUsers()
        userListLiveData.value = users
    }

    fun queryUserList(){
        val users = userListRepo.getUsers()
        userListLiveData.value = users
    }
}