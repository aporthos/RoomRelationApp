package com.globant.shared.data.datasource.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.globant.shared.data.model.SchoolEntity
import com.globant.shared.data.model.StudentEntity

data class SchoolWithStudents(
    @Embedded val schoolEntity: SchoolEntity,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolOwnerName"
    )
    val studentEntities: List<StudentEntity>
)