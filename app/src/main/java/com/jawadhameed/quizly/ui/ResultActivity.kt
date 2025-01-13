package com.jawadhameed.quizly.ui

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jawadhameed.quizly.R
import com.jawadhameed.quizly.databinding.ActivityResultBinding
import com.jawadhameed.quizly.utils.Utils

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    private var correctAnswers = 0
    private var incorrectAnswers = 0
    private var totalQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        correctAnswers = intent.getIntExtra("correctAnswers", 0)
        incorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        totalQuestions = correctAnswers + incorrectAnswers

        binding.correctAnswers.text = "Correct Answers: $correctAnswers"
        binding.incorrectAnswers.text = "Incorrect Answers: $incorrectAnswers"

        val percentage = (correctAnswers.toFloat() / totalQuestions) * 100

        if (percentage > Utils.getHighScore(this@ResultActivity)){
            Utils.saveHighScore(this@ResultActivity, percentage)
        }

        when {
            percentage > 80 -> {
                binding.encouragingWords.text = "Great!"
                binding.emojiImage.setImageResource(R.drawable.happy)
                binding.correctAnswers.setTextColor(Color.parseColor("#4CAF50"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
            }
            percentage in 60.0..80.0 -> {
                binding.encouragingWords.text = "Good Try!"
                binding.emojiImage.setImageResource(R.drawable.neutral)
                binding.correctAnswers.setTextColor(Color.parseColor("#FFC107"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#F44336"))
            }
            else -> {
                binding.encouragingWords.text = "Try Again"
                binding.emojiImage.setImageResource(R.drawable.sad)
                binding.correctAnswers.setTextColor(Color.parseColor("#F44336"))
                binding.incorrectAnswers.setTextColor(Color.parseColor("#4CAF50"))
            }
        }

        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}
