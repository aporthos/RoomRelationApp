package com.globant.shared.data.mapper

import com.globant.shared.data.model.StudentEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolAndDirectorDto
import com.globant.shared.domain.model.StudentDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentListMapper @Inject constructor(private val studentMapper: StudentMapper) :
    Transform<List<StudentEntity>, List<StudentDto>>() {
    override fun transform(value: List<StudentEntity>): List<StudentDto> =
        mutableListOf<StudentDto>().apply {
            value.map {
                add(studentMapper.transform(it))
            }
        }
}