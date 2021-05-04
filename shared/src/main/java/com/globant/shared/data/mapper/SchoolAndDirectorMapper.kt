package com.globant.shared.data.mapper

import com.globant.shared.data.datasource.local.relations.SchoolAndDirector
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolAndDirectorDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolAndDirectorMapper @Inject constructor(
    private val schoolMapper: SchoolMapper,
    private val directorMapper: DirectorMapper
) : Transform<SchoolAndDirector, SchoolAndDirectorDto>() {
    override fun transform(value: SchoolAndDirector): SchoolAndDirectorDto = SchoolAndDirectorDto(
        schoolMapper.transform(value.schoolEntity), directorMapper.transform(value.directorEntity)
    )
}