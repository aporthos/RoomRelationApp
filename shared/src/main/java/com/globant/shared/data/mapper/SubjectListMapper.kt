package com.globant.shared.data.mapper

import com.globant.shared.data.model.SubjectEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.SubjectDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectListMapper @Inject constructor(private val subjectMapper: SubjectMapper) :
    Transform<List<SubjectEntity>, List<SubjectDto>>() {
    override fun transform(value: List<SubjectEntity>): List<SubjectDto> =
        mutableListOf<SubjectDto>().apply {
            value.map {
                add(subjectMapper.transform(it))
            }
        }
}