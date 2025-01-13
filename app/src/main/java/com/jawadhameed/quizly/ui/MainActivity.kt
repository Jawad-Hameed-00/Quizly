package com.jawadhameed.quizly.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jawadhameed.quizly.R
import com.jawadhameed.quizly.databinding.ActivityMainBinding
import com.jawadhameed.quizly.utils.Utils
import com.jawadhameed.quizly.utils.Utils.getHighScore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.highScore.text = "${getHighScore(this@MainActivity)} % \n High Score"

        binding.startQuizButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        binding.highScore.text = "${getHighScore(this@MainActivity)} % \n High Score"
    }

}