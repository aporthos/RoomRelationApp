package com.globant.shared.domain.model

data class SubjectWithStudentsDto(val subject: SubjectDto, val student: List<StudentDto>)