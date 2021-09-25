package com.example.exploreapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exploreapp.fragments.MainFragment
import com.example.exploreapp.fragments.secondFragment
import com.example.exploreapp.fragments.thirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val firstFragment= MainFragment()
        val secondFragment= secondFragment()
        val thirdFragment= thirdFragment()

        setCurrentFragment(firstFragment)
        val navView : BottomNavigationView = findViewById(R.id.bottom_nav_view)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab1 -> setCurrentFragment(firstFragment)
                R.id.tab2 -> setCurrentFragment(secondFragment)
                R.id.tab3 -> setCurrentFragment(thirdFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view,fragment)
            commit()
        }

}