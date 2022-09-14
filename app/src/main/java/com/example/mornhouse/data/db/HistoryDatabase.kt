package com.example.mornhouse.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mornhouse.models.HistoryModel

/**
 * The Room database for this app
 */

@Database(entities = [HistoryModel::class], version = 1)
abstract class HistoryDatabase : RoomDatabase(){

    abstract val historyDao: HistoryDao

    companion object{
        const val DATABASE_NAME = "history_db"
    }
}