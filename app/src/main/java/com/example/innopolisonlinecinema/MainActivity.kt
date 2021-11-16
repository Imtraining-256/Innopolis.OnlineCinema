package com.example.innopolisonlinecinema

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment(MoviesListFragment())
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(android.R.id.content, fragment).commit()
    }
}