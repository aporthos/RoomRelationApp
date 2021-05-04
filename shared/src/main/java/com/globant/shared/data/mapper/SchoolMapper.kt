package com.globant.shared.data.mapper

import com.globant.shared.data.model.SchoolEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SchoolDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolMapper @Inject constructor(): Transform<SchoolEntity, SchoolDto>() {
    override fun transform(value: SchoolEntity): SchoolDto = SchoolDto(schoolName = value.schoolName)
}