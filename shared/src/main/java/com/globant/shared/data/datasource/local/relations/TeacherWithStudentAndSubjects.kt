package com.globant.shared.data.datasource.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.globant.shared.data.model.TeacherEntity

data class TeacherWithStudentAndSubjects(
    @Embedded val teacherEntity: TeacherEntity,
    @Relation(
        entity = com.globant.shared.data.model.StudentEntity::class,
        parentColumn = "teacherName",
        entityColumn = "teacherOwnerName"
    )
    val students: List<StudentWithSubjects>
)