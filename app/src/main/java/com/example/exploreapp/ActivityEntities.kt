package com.example.exploreapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities_table")
data class ActivityEntities(
    @PrimaryKey(autoGenerate = true) val aid : Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "user_id") val user_id : Int,
    @ColumnInfo(name = "image") val image : String,
    @ColumnInfo(name = "location") val location : String,
    @ColumnInfo(name = "difficulty") val difficulty : Int,
    @ColumnInfo(name = "points") val points : Int,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "completion") val completion : Boolean,
    @ColumnInfo(name = "time") val time : String
)
