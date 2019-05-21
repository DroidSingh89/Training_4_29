package com.example.training_4_29.ui.activity.github

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.databinding.ActivityGithubBinding
import com.example.training_4_29.model.entities.github.GithubRepo

class GithubActivity : BaseActivity() {

    val githubViewModel: GithubViewModel by lazy { ViewModelProviders.of(this).get(GithubViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val githubBinding: ActivityGithubBinding = DataBindingUtil.setContentView(this, R.layout.activity_github)


        githubBinding.viewmodel = githubViewModel

        githubViewModel.repoData.observe(this, Observer<List<GithubRepo>> { list ->
            list.forEach { Log.d(GithubActivity::class.java.simpleName, "onCreate: ${it.name}") }
            githubBinding.repo = list[0]
        })

        findViewById<Button>(R.id.btnUpdateRepo).setOnClickListener { githubViewModel.updateRepoList("manroopsingh") }


    }
}
