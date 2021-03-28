package com.megamott.rl2_legengs.abstracts.repo.impl

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.megamott.rl2_legengs.abstracts.repo.UserListRepo
import com.megamott.rl2_legengs.abstracts.util.*

class UserListImplFirebase : UserListRepo {
    private val usersList = StringBuilder()

    override fun getUsers(): StringBuilder {
        initFirebase()

        val getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children){
                    val id = i.child("1").child(CHILD_ID).value
                    val answer = i.child("1").child(CHILD_ANSWER).value
                    val text = i.child("2").child(CHILD_TEXT).value
                    usersList.append("$id $text $answer")
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }

        REF_DATABASE_ROOT.addValueEventListener(getData)
        REF_DATABASE_ROOT.addListenerForSingleValueEvent(getData)
        return usersList
    }

}