package com.example.mornhouse.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.mornhouse.R
import com.example.mornhouse.databinding.ActivitySecondBinding
import com.example.mornhouse.presentation.HistoryViewModel

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val mViewModel by viewModels<HistoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val number = intent.getStringExtra("number")

        binding.tvNumber.text = number
        binding.tvDescription.text =
    }
}