package com.example.mornhouse.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mornhouse.databinding.FragmentHistoryBinding
import com.example.mornhouse.presentation.AdapterHistoryItem
import com.example.mornhouse.presentation.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: AdapterHistoryItem


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel by viewModels<HistoryViewModel>()
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        recycler = binding.historyRecycler
        adapter = AdapterHistoryItem()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.liveHistory.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }

        return binding.root
    }

}