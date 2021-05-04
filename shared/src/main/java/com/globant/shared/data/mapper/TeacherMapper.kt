package com.globant.shared.data.mapper

import com.globant.shared.data.model.TeacherEntity
import com.globant.shared.domain.Transform
import com.globant.shared.domain.model.TeacherDto

class TeacherMapper: Transform<TeacherEntity, TeacherDto>() {
    override fun transform(value: TeacherEntity): TeacherDto = TeacherDto(teacherName = value.teacherName)
}