package com.globant.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DirectorEntity(
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolOwnerName: String
)