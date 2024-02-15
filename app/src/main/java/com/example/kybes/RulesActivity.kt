package com.example.kybes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
            val backButton: Button = findViewById(R.id.BackRules)

            backButton.setOnClickListener {
                val intent = Intent(this@RulesActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
