package com.example.exploreapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExplorerDao {

    @Query("SELECT * FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserById(id : Int) : ExplorerEntities.User

    @Query("SELECT experience FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserExperience(id : Int) : Int

    @Query("SELECT level FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserLevel(id : Int) : Int

    @Query("SELECT badges FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserBadges(id: Int) : Flow<List<String>>

    @Query("SELECT activities FROM userWithActivities_table WHERE uid IN (:id)")
    fun getUserActivities(id :Int) : Flow<List<ExplorerEntities.Activities>>

    @Insert()
    fun updateCompletion(id: Int, status : Boolean)

    @Insert()
    fun updateLevel(uid: Int, amount : Int)

    @Query("DELETE FROM userWithActivities_table WHERE uid IN (:id)")
    suspend fun deleteUser(id : Int) : Int

    @Query("SELECT COUNT(*) FROM activities_table")
    fun getTotalActivities() : Int
}