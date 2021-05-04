package com.globant.shared.domain.model

data class StudentDto(
    val studentName: String,
    val semester: Int,
    val schoolOwnerName: String,
    val teacherOwnerName: String
)