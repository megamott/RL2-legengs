package com.megamott.rl2_legengs.abstracts.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val qId: Int,
    val qText: String,
    val qAnswer: String,
    val options: ArrayList<String>
) : Parcelable