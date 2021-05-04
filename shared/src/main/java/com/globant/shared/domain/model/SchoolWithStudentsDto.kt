package com.globant.shared.domain.model

data class SchoolWithStudentsDto(val school: SchoolDto, val student: List<StudentDto>)