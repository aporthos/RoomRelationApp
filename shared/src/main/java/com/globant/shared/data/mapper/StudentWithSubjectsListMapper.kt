package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.StudentWithSubjects
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.StudentWithSubjectsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentWithSubjectsListMapper @Inject constructor(private val studentWithSubjectsMapper: StudentWithSubjectsMapper) :
    Transform<List<StudentWithSubjects>, List<StudentWithSubjectsDto>>() {
    override fun transform(value: List<StudentWithSubjects>): List<StudentWithSubjectsDto> =
        mutableListOf<StudentWithSubjectsDto>().apply {
            value.map {
                add(studentWithSubjectsMapper.transform(it))
            }
        }
}