package com.globant.shared.data.mapper

import com.globant.shared.data.model.SubjectEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SubjectDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectMapper @Inject constructor(): Transform<SubjectEntity, SubjectDto>() {
    override fun transform(value: SubjectEntity): SubjectDto = SubjectDto(subjectName = value.subjectName)
}