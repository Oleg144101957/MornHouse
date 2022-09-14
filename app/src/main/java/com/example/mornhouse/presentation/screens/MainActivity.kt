package com.example.mornhouse.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mornhouse.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchFragment = SearchFragment()
        val historyFragment = HistoryFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.searchContainer, searchFragment)
            replace(R.id.historyContainer, historyFragment)
        }.commit()
    }
}