package com.megamott.rl2_legengs.abstracts.repo

import com.megamott.rl2_legengs.abstracts.entity.User

interface UserListRepo {
    fun getUsers() : MutableList<User>
}