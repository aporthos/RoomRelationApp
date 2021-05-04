package com.globant.shared.data.mapper

import com.globant.shared.data.model.StudentEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.StudentDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentMapper @Inject constructor(): Transform<StudentEntity, StudentDto>() {
    override fun transform(value: StudentEntity): StudentDto = StudentDto(
        studentName = value.studentName,
        semester = value.semester,
        schoolOwnerName = value.schoolOwnerName,
        teacherOwnerName = value.teacherOwnerName
    )
}