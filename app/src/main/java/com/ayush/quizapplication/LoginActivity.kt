package com.ayush.quizapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.ayush.quizapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding  = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        loginBinding.editTextText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                loginBinding.button.isEnabled = s.toString() != ""
                if (loginBinding.button.isEnabled) {
                    loginBinding.button.setTextColor(Color.GREEN)
                }
                else{
                    loginBinding.button.setTextColor(Color.RED)
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        loginBinding.button.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java).putExtra("Name",loginBinding.editTextText.text.toString()))
            finish()
        }
    }
}