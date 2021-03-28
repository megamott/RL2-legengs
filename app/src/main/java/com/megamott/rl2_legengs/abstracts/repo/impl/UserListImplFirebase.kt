package com.megamott.rl2_legengs.abstracts.repo.impl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.util.REF_DATABASE_ROOT
import com.megamott.rl2_legengs.abstracts.util.initFirebase

class UserListImplFirebase : UserListRepo {
    private val usersList : MutableList<String> = ArrayList()

    init {
        initFirebase()
        val getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (usersList.isNotEmpty()) usersList.clear()
                for (ds in snapshot.children){
                    val user = ds.value
                    usersList.add(user.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }

        REF_DATABASE_ROOT.addValueEventListener(getData)
    }

    override fun getUsers(): MutableList<String> {
        return usersList
    }

}