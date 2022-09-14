package com.example.mornhouse.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mornhouse.data.api.MainService
import com.example.mornhouse.data.repository.HistoryRepositoryImpl
import com.example.mornhouse.models.HistoryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor (
    private val repository: HistoryRepositoryImpl,
    private val api: MainService
) : ViewModel() {

    val liveHistory: LiveData<List<HistoryModel>> = repository.readAllHistory
    val liveDescription: LiveData<Response<String>> = api.getRandomNumberDescription()

    fun addNumberToHistory(number: HistoryModel){
        viewModelScope.launch (Dispatchers.IO){
            repository.addNumberToDb(number)
        }
    }

}