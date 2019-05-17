package com.dondyprax.labo07.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.dondyprax.labo07.Database.GitHubDAO
import com.dondyprax.labo07.Database.GitHubRepo

class GithubRepoRepository (private val repoDao: GitHubDAO){

    @WorkerThread
    suspend fun insert(repo: GitHubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GitHubRepo>> = repoDao.getAllRepost()

    fun nuke() = repoDao.nukeRable()

}