package com.example.mornhouse.domain.usecases

import com.example.mornhouse.domain.repository.HistoryRepository
import com.example.mornhouse.models.HistoryModel

class SaveInfoToDatabase(private val repository: HistoryRepository) {

    suspend operator fun invoke(numberToSave: HistoryModel){
        repository.addNumberToDb(numberToSave)
    }


}