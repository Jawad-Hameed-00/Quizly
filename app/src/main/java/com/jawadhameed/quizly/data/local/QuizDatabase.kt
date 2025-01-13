package com.jawadhameed.quizly.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quiz::class], version = 1, exportSchema = true)
abstract class QuizDatabase : RoomDatabase(){

    abstract fun quizDao():QuizDao

    companion object{
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context):QuizDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuizDatabase::class.java,
                        "quiz_db").createFromAsset("database/db_quizly.db").build()
                }
            }
            return INSTANCE!!
        }
    }
}