package com.example.exploreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //test
        val button: Button = findViewById(R.id.buttontoswitch)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_2 -> {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    // Respond to navigation item 2 click
                    true

                }
                else -> false
            }
        }
    }
}