package com.megamott.rl2_legengs.abstracts.util

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var REF_DATABASE_ROOT:DatabaseReference

const val NODE_QUESTIONS = "question"
const val CHILD_ID = "id"
const val CHILD_TEXT = "text"
const val CHILD_ANSWER = "answer"
const val CHILD_OPTIONS = "options"

const val NODE_USER = "user"

fun initFirebase(){
    REF_DATABASE_ROOT = FirebaseDatabase.getInstance().reference
}