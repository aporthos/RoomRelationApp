package com.globant.shared.data.datasource.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.globant.shared.data.model.DirectorEntity
import com.globant.shared.data.model.SchoolEntity

/*
    Relation 1 -> 1
    parentColumn -> Entity = School,
    entityColumn -> Entity = Director
 */
data class SchoolAndDirector(
    @Embedded val schoolEntity: SchoolEntity,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolOwnerName"
    )
    val directorEntity: DirectorEntity
)