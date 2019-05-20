package com.example.training_4_29.model.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.training_4_29.model.entities.github.GithubRepo
import com.example.training_4_29.network.RemoteDataSource

class GithubRepository {

    val repoData = MutableLiveData<List<GithubRepo>>()
    private val remoteDataSource = RemoteDataSource()

    fun getRepoList(username: String):LiveData<List<GithubRepo>>{
        remoteDataSource.getRepoList(username){
            repoData.value = it
        }
        return repoData
    }

}