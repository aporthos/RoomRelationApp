package com.globant.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SchoolEntity(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)