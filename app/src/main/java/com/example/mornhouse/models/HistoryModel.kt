package com.example.mornhouse.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "history_table")
data class HistoryModel(
    @PrimaryKey
    val id: String = "",
    @ColumnInfo
    val description: String
)

class InvalidSearchNumberException (message: String) : Exception(message)