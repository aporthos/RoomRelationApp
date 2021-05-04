package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.SchoolAndDirector
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolAndDirectorDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolAndDirectorListMapper @Inject constructor(private val schoolAndDirectorMapper: SchoolAndDirectorMapper) :
    Transform<List<SchoolAndDirector>, List<SchoolAndDirectorDto>>() {
    override fun transform(value: List<SchoolAndDirector>): List<SchoolAndDirectorDto> =
        mutableListOf<SchoolAndDirectorDto>().apply {
            value.map {
                add(schoolAndDirectorMapper.transform(it))
            }
        }
}