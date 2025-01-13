package com.jawadhameed.quizly.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jawadhameed.quizly.data.remote.QuizRepository

class QuizViewModelFactory(private val quizRepository: QuizRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        @Suppress("UNCHECKED_CAST")
        return QuizViewModel(quizRepository) as T
    }
}