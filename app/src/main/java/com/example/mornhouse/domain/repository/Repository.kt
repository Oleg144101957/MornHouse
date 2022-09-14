package com.example.mornhouse.domain.repository

import androidx.lifecycle.LiveData
import com.example.mornhouse.models.HistoryModel
import retrofit2.Response

interface HistoryRepository {

    val readAllHistory: LiveData<List<HistoryModel>>

    suspend fun addNumberToDb(number: HistoryModel)

    suspend fun getNumberFromDb(id: String)

    suspend fun getRandomNumberDescription(): Response<String>

}