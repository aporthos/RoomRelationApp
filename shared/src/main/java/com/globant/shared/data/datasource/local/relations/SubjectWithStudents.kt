package com.globant.shared.data.datasource.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.globant.shared.data.model.StudentEntity
import com.globant.shared.data.model.StudentSubjectCrossRef
import com.globant.shared.data.model.SubjectEntity

data class SubjectWithStudents(
    @Embedded val subjectEntity: SubjectEntity,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )

    val studentEntities: List<StudentEntity>
)