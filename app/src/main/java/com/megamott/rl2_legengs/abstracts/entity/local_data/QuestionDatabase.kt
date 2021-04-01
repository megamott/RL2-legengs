package com.megamott.rl2_legengs.abstracts.entity.local_data

import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Question::class], version = 1, exportSchema = false)
abstract class QuestionDatabase : RoomDatabase(){

    abstract fun questionDao(): QuestionDAO

    companion object {
        @Volatile
        private var INSTANCE : QuestionDatabase? = null

        fun getDatabase(context: Context): QuestionDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDatabase::class.java,
                    "question_database"
                ).addCallback(rdc)
                        .allowMainThreadQueries()
                        .build()
                INSTANCE = instance
                return instance
            }
        }

        private val rdc = object : Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                val contentValues1 = ContentValues()
                contentValues1.put("id", 1)
                contentValues1.put("question_text", "Кто я?")
                contentValues1.put("question_answer", "Матвей")
                contentValues1.put("question_options", "Матвей 1 2 3")

                val contentValues2 = ContentValues()
                contentValues2.put("id", 2)
                contentValues2.put("question_text", "Кто я такой?")
                contentValues2.put("question_answer", "Матвей")
                contentValues2.put("question_options", "Матвей 1 2 3")

                val contentValues3 = ContentValues()
                contentValues3.put("id", 3)
                contentValues3.put("question_text", "Кто я всё таки?")
                contentValues3.put("question_answer", "Матвей")
                contentValues3.put("question_options", "Матвей 1 2 3")

                db.insert("question_table", OnConflictStrategy.REPLACE, contentValues1)
                db.insert("question_table", OnConflictStrategy.REPLACE, contentValues2)
                db.insert("question_table", OnConflictStrategy.REPLACE, contentValues3)

                Log.d("db create","table created when db created first time in  onCreate")
            }
        }
    }
}

