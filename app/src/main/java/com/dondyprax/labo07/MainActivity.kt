package com.dondyprax.labo07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dondyprax.labo07.Database.GitHubRepo
import com.dondyprax.labo07.ViewModels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        button.setOnClickListener{
            val name = editText.text.toString()
            if (name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GitHubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer {repos ->
            Log.d("LISTA DE REPOS", "_________________________")
            for (repo in repos){
                Log.d("LISTA DE REPOS", repo.name)
            }
        })
    }
}
