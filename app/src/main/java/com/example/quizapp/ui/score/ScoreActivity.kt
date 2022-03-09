package com.example.quizapp.ui.score

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityScoreBinding
import com.example.quizapp.ui.main.MainActivity

class ScoreActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SCORE = "extra_score"
        const val EXTRA_NICKNAME = "extra_nickname"
    }

    private lateinit var scoreBinding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scoreBinding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(scoreBinding.root)

        // Get Data
        if (intent != null) {
            val score = intent.getIntExtra(EXTRA_SCORE, 0)
            val nickname = intent.getStringExtra(EXTRA_NICKNAME)

            scoreBinding.tvNickname.text = nickname
            scoreBinding.tvScore.text = score.toString()
        }
        onClick()
    }

    private fun onClick() {
        scoreBinding.btnDone.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }
}