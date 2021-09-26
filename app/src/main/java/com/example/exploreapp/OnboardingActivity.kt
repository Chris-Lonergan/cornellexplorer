package com.example.exploreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val button: ImageButton = findViewById(R.id.letsgo)
        button.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }
}