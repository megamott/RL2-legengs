package com.megamott.rl2_legengs.abstracts.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val id: Int,
    val text: String,
    val answer: String,
    val options: ArrayList<String>
) : Parcelable