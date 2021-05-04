package com.globant.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubjectEntity(
    @PrimaryKey(autoGenerate = false)
    val subjectName: String
)