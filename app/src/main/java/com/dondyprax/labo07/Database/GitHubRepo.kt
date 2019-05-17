package com.dondyprax.labo07.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GitHubRepo(

    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}