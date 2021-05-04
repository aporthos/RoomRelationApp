package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.StudentWithSubjects
import com.globant.shared.data.datasource.local.relations.SubjectWithStudents
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectsWithStudentsListMapper @Inject constructor(private val subjectWithStudentsMapper: SubjectsWithStudentsMapper) :
    Transform<List<SubjectWithStudents>, List<SubjectWithStudentsDto>>() {

    override fun transform(value: List<SubjectWithStudents>): List<SubjectWithStudentsDto> =
        mutableListOf<SubjectWithStudentsDto>().apply {
            value.map {
                add(subjectWithStudentsMapper.transform(it))
            }
        }

}