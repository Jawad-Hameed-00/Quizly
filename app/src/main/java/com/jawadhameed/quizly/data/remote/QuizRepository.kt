package com.jawadhameed.quizly.data.remote

import androidx.lifecycle.LiveData
import com.jawadhameed.quizly.data.local.Quiz
import com.jawadhameed.quizly.data.local.QuizDao

class QuizRepository(private val quizDao: QuizDao) {

    fun getQuizList():LiveData<List<Quiz>>{
        return quizDao.getQuizList()
    }
}