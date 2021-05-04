package com.globant.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TeacherEntity(
    @PrimaryKey(autoGenerate = false)
    val teacherName: String
)