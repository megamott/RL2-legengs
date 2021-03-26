package com.megamott.rl2_legengs.abstracts.entity

data class Question(
    val qId: Int,
    val qText: String,
    val qAnswer: String,
    val options: ArrayList<String>
)