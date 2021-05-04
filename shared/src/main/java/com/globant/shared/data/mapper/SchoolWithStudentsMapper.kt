package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolDto
import com.globant.shared.domain.model.SchoolWithStudentsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolWithStudentsMapper @Inject constructor(
    private val schoolMapper: SchoolMapper,
    private val studentListMapper: StudentListMapper
) : Transform<SchoolWithStudents, SchoolWithStudentsDto>() {
    override fun transform(value: SchoolWithStudents): SchoolWithStudentsDto =
        SchoolWithStudentsDto(
            school = schoolMapper.transform(value.schoolEntity),
            student = studentListMapper.transform(value.studentEntities)
        )

}