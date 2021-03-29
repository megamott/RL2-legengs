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

class UserListViewModel : ViewModel() {
    private lateinit var dataLoadListener: DataLoadListener
    private lateinit var userListRepo: UserListRepo
    private var userListLiveData: MutableLiveData<MutableList<User>> = MutableLiveData()
    private var userList: MutableList<User> = ArrayList()

    fun init(dataLoadListener: DataLoadListener) {
        this.dataLoadListener = dataLoadListener
        userListRepo = UserListImplFirebase(dataLoadListener)
        userList = userListRepo.getUsers()
    }

    fun getUsersLiveData(): LiveData<MutableList<User>> {
        userListLiveData.value = userList
        return userListLiveData
    }
}