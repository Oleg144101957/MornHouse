package com.example.mornhouse.presentation.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mornhouse.models.HistoryModel
import com.example.mornhouse.databinding.FragmentSearchBinding
import com.example.mornhouse.presentation.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val mViewModel by viewModels<HistoryViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        binding.btnSearchNumb.setOnClickListener {
            addNumberToDatabase()
        }

        binding.btnSearchRandomNumb.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            intent.putExtra("number", binding.etSearch.text.toString())
            startActivity(intent)
        }

        return binding.root
    }

    private fun addNumberToDatabase(){

        if (binding.etSearch.text.isNotEmpty()){
            val id = binding.etSearch.text.toString()
            val description = "Hello World"
            val itemToAdd = HistoryModel(id, description)
            mViewModel.addNumberToHistory(itemToAdd)
        } else {
            Toast.makeText(
                requireContext(),
                "Enter number or press Random button",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}