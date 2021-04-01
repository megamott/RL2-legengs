package com.megamott.rl2_legengs.abstracts.entity.local_data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestions(question: Question)

    @Query("SELECT * FROM question_table ORDER BY id ASC")
    fun readAllQuestions() : List<Question>

}