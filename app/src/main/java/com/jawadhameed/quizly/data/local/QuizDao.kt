package com.jawadhameed.quizly.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface QuizDao {

    @Query("SELECT * FROM quiz")
    fun getQuizList():LiveData<List<Quiz>>
}