package com.example.mvpexample.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpexample.R
import com.example.mvpexample.ui.fragments.main.MainScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment()).commit()
    }

}