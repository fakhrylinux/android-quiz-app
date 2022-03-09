package com.example.quizapp.ui.prepare

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityPrepareBinding
import com.example.quizapp.ui.content.ContentActivity

class PrepareActivity : AppCompatActivity() {

    private lateinit var prepareBinding: ActivityPrepareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBinding = ActivityPrepareBinding.inflate(layoutInflater)
        setContentView(prepareBinding.root)

        onClick()
    }

    private fun onClick() {
        prepareBinding.btnStart.setOnClickListener {
            val nickname = prepareBinding.etNickname.text.toString()
            if (checkValidation(nickname)) {
                val intent = Intent(this, ContentActivity::class.java)
                intent.putExtra(ContentActivity.EXTRA_NICKNAME, nickname)
                startActivity(intent)
//                startActivity<ContentActivity>(
//                    ContentActivity.EXTRA_NICKNAME to nickname
//                )
            }
        }
    }

    private fun checkValidation(nickname: String): Boolean {
        return if (nickname.isEmpty()) {
            prepareBinding.etNickname.error = getString(R.string.please_field_your_nickname)
            false
        } else {
            true
        }
    }
}