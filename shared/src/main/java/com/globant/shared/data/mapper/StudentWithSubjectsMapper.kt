package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.StudentWithSubjects
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.StudentWithSubjectsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentWithSubjectsMapper @Inject constructor(
    private val studentMapper: StudentMapper,
    private val subjectListMapper: SubjectListMapper
) : Transform<StudentWithSubjects, StudentWithSubjectsDto> () {
    override fun transform(value: StudentWithSubjects): StudentWithSubjectsDto = StudentWithSubjectsDto(
        student = studentMapper.transform(value.studentEntity),
        subject = subjectListMapper.transform(value.subjectEntities)
    )
}