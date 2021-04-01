package com.megamott.rl2_legengs.abstracts.entity.local_data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "question_table")
data class Question(
    @ColumnInfo(name = "question_text")
    var text: String,

    @ColumnInfo(name = "question_answer")
    var answer: String,

    @ColumnInfo(name = "question_options")
    var options: String

) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0
}