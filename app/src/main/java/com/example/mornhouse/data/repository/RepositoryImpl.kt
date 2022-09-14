package com.example.mornhouse.data.repository

import androidx.lifecycle.LiveData
import com.example.mornhouse.data.api.MainService
import com.example.mornhouse.data.db.HistoryDao
import com.example.mornhouse.models.HistoryModel
import com.example.mornhouse.domain.repository.HistoryRepository
import retrofit2.Response
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    val historyDao: HistoryDao,
    val mainService: MainService
    ) : HistoryRepository{

    override val readAllHistory: LiveData<List<HistoryModel>>
        get() = historyDao.readAllHistory()

    override suspend fun getNumberFromDb(id: String) {
        historyDao.getNumberFromHistoryDb(id)
    }

    override suspend fun getRandomNumberDescription(): Response<String> {
        return mainService.getRandomNumberDescription()
    }

    override suspend fun addNumberToDb(number: HistoryModel) {
        historyDao.addNumberToHistory(number)
    }


}