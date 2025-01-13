package com.jawadhameed.quizly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jawadhameed.quizly.data.local.Quiz
import com.jawadhameed.quizly.data.remote.QuizRepository

class QuizViewModel(quizRepository: QuizRepository) : ViewModel() {

    val quizList: LiveData<List<Quiz>> = quizRepository.getQuizList()

}
