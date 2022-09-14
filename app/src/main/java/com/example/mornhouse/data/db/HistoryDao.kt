package com.example.mornhouse.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mornhouse.models.HistoryModel


@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_table")
    fun readAllHistory(): LiveData<List<HistoryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNumberToHistory(number: HistoryModel)

    @Query("SELECT * FROM history_table WHERE id = :id")
    suspend fun getNumberFromHistoryDb(id: String) : HistoryModel


}