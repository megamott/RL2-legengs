package com.megamott.rl2_legengs.abstracts.repo.impl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.megamott.rl2_legengs.abstracts.entity.User
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.util.NODE_USER
import com.megamott.rl2_legengs.abstracts.util.REF_DATABASE_ROOT
import com.megamott.rl2_legengs.abstracts.util.initFirebase
import com.megamott.rl2_legengs.abstracts.view_model.dataLoadedListener.DataLoadListener

class UserListImplFirebase(private val dataLoadListener: DataLoadListener) : UserListRepo {
    private val usersList : MutableList<User> = ArrayList()

    override fun getUsers(): MutableList<User> {
        loadUsers()
        return usersList
    }

    private fun loadUsers() {
        initFirebase()
        val query = REF_DATABASE_ROOT.child(NODE_USER)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (usersList.isNotEmpty()) usersList.clear()
                for (ds in snapshot.children){
                    ds.getValue(User::class.java)?.let { usersList.add(it) }
                }
                dataLoadListener.onLoad()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }

}