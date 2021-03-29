package com.megamott.rl2_legengs.abstracts.repo

import com.megamott.rl2_legengs.abstracts.entity.User
import com.megamott.rl2_legengs.abstracts.view_model.dataLoadedListener.DataLoadListener

interface UserListRepo {
    fun getUsers() : MutableList<User>
    fun getInitUsers(dataLoadListener: DataLoadListener) : MutableList<User>
}