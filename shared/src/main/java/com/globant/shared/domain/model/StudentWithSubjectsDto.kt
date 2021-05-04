package com.globant.shared.domain.model

data class StudentWithSubjectsDto(val student: StudentDto, val subject: List<SubjectDto>)