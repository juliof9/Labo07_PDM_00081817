package com.dondyprax.labo07.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.dondyprax.labo07.Database.GitHubRepo
import com.dondyprax.labo07.Database.RoomDB
import com.dondyprax.labo07.Repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app){
    private val repository : GithubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }

    fun insert(repo: GitHubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GitHubRepo>> = repository.getAll()

    fun nukeAll() = repository.nuke()
}