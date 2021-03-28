package com.megamott.rl2_legengs.abstracts.repo

interface UserListRepo {
    fun getUsers() : MutableList<String>
}