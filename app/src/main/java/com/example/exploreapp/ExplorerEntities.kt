//package com.example.exploreapp
//
//import androidx.room.*
//
//class ExplorerEntities{
//    @Entity(tableName = "user_table")
//    data class User(
//        @PrimaryKey(autoGenerate = true) val uid: Int,
//        @ColumnInfo(name = "username") val username: String,
//        @ColumnInfo(name = "level") val level: Int,
//        @ColumnInfo(name = "experience") val exp: Int,
//        @ColumnInfo(name = "badges") val badges: List<String>,
//        @ColumnInfo(name = "completed") val completed : List<String>
//    )
//
//    @Entity(tableName = "activities_table")
//    data class Activity(
//        @PrimaryKey(autoGenerate = true) val aid : Int,
//        @ColumnInfo(name = "title") val title : String,
//        @ColumnInfo(name = "user_id") val user_id : Int,
//        @ColumnInfo(name = "image") val image : String,
//        @ColumnInfo(name = "location") val location : String,
//        @ColumnInfo(name = "difficulty") val difficulty : Int,
//        @ColumnInfo(name = "points") val points : Int,
//        @ColumnInfo(name = "description") val description : List<String>,
//        @ColumnInfo(name = "completion") val completion : Boolean,
//        @ColumnInfo(name = "time") val time : String
//    )
//}