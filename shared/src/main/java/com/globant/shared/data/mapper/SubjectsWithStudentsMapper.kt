package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.SubjectWithStudents
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SubjectDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectsWithStudentsMapper @Inject constructor(
    private val subjectMapper: SubjectMapper,
    private val studentListMapper: StudentListMapper
) : Transform<SubjectWithStudents, SubjectWithStudentsDto>() {
    override fun transform(value: SubjectWithStudents): SubjectWithStudentsDto =
        SubjectWithStudentsDto(
            subject = subjectMapper.transform(value.subjectEntity),
            student = studentListMapper.transform(value.studentEntities)
        )
}