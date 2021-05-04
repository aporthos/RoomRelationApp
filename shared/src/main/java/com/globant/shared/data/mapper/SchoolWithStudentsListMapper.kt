package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.data.model.SchoolEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolWithStudentsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolWithStudentsListMapper @Inject constructor(
    private val schoolWithStudentsMapper: SchoolWithStudentsMapper
) : Transform<List<SchoolWithStudents>, List<SchoolWithStudentsDto>> (){
    override fun transform(value: List<SchoolWithStudents>): List<SchoolWithStudentsDto> = mutableListOf<SchoolWithStudentsDto>().apply {
        value.map {
            add(schoolWithStudentsMapper.transform(it))
        }
    }
}