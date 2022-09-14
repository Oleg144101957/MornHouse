package com.example.mornhouse.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mornhouse.models.HistoryModel
import com.example.mornhouse.databinding.HistoryItemBinding

class AdapterHistoryItem : RecyclerView.Adapter<AdapterHistoryItem.HistoryHolder>() {
    inner class HistoryHolder (val binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    var listOfNumbers = emptyList<HistoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        return HistoryHolder(HistoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val item = listOfNumbers[position]

        holder.binding.apply {
            number.text = item.id
            description.text = item.description
        }
    }

    override fun getItemCount() = listOfNumbers.size

    fun setList(list: List<HistoryModel>){
        listOfNumbers = list
        notifyDataSetChanged()
    }
}