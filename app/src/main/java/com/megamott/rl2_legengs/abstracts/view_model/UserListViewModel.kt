package com.megamott.rl2_legengs.abstracts.view_model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.megamott.rl2_legengs.abstracts.entity.User
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.repo.impl.UserListImplFirebase
import com.megamott.rl2_legengs.abstracts.view_model.dataLoadedListener.DataLoadListener
import java.lang.StringBuilder

class UserListViewModel : ViewModel(), DataLoadListener {
    private val userListRepo: UserListRepo
    private var userList: MutableList<User> = ArrayList()

    var userListLiveData: MutableLiveData<MutableList<User>> = MutableLiveData(userList)

    init {
        userListRepo = UserListImplFirebase
        userList = userListRepo.getInitUsers(this)
    }

    override fun onLoad() {
        userList = userListRepo.getUsers()
        userListLiveData.value = userList
    }
}