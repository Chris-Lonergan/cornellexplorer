package com.example.exploreapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ExplorerRepository (private val explorerDao : ExplorerDao){

    fun getUserById(uid : Int) : ExplorerEntities.UserWithActivities = explorerDao.getUserById(uid)

    fun setUserExperience(uid : Int, experience: Int) = explorerDao.updateExperience(uid, experience)

    fun getUserExperience(uid : Int) = explorerDao.getUserExperience(uid)

    fun updateUserLevel(uid: Int, experience : Int) = explorerDao.updateLevel(uid, experience % explorerDao.getUserLevel(uid))

    fun getUserBadges(uid : Int) : Flow<List<String>> = explorerDao.getUserBadges(uid)

    fun getUserActivities(uid: Int): Flow<List<ExplorerEntities.Activity>> = explorerDao.getUserActivities(uid)

    fun createUser(username : String) = explorerDao.createUser(username, 0, 0, emptyList(), emptyList())

    fun createActivity(user_id: Int, image : String, location : String, difficulty : String, points : Int, description: List<String>) = explorerDao.createActivity(user_id, image, location, difficulty, points, description, false, "Not completed")

    fun updateCompletion(uid: Int, status : Boolean) = explorerDao.updateCompletion(uid, status)

    fun getCompletedActivities(uid: Int) : Flow<List<ExplorerEntities.Activity>> = explorerDao.getCompletedActivities(uid)

    fun getIncompletedActivities(uid : Int) : Flow<List<ExplorerEntities.Activity>> = explorerDao.getIncompletedActivities(uid)


}