package com.example.exploreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.flow.forEach

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

        val db = ExplorerDatabase.getInstance(this)
        db.explorerDao().createUser("rachel", 0, 0, emptyList(), emptyList())
        db.explorerDao().createUser("chris", 0, 0, emptyList(), emptyList())
        db.explorerDao().createUser("michelle", 0, 0, emptyList(), emptyList())
        val data = db.explorerDao().getAllUsers().isEmpty()

        Log.d("LOOK HERE PLEASE", data.toString())





    }
}