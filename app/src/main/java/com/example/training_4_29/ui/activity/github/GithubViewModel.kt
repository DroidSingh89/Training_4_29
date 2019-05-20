package com.example.training_4_29.ui.activity.github

import androidx.lifecycle.ViewModel
import com.example.training_4_29.model.data.repository.GithubRepository

class GithubViewModel: ViewModel() {

    val githubRepository = GithubRepository()
    val repoData =  githubRepository.repoData

    fun updateRepoList(username: String){
        githubRepository.getRepoList(username)
    }
}