package com.jawadhameed.quizly.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Quiz")
data class Quiz(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val question:String = "",
    val option1:String = "",
    val option2:String = "",
    val option3:String = "",
    val option4:String = "",
    val answer: String = ""
)
