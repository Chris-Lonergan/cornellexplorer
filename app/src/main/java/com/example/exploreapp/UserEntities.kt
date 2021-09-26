package com.example.exploreapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntities(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "level") val level: Int,
    @ColumnInfo(name = "experience") val exp: Int,
    @ColumnInfo(name = "badges") val badges: List<String>,
    @ColumnInfo(name = "completed") val completed : List<String>
    )