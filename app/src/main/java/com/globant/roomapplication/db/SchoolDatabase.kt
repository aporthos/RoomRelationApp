package com.globant.roomapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.globant.shared.data.datasource.local.SchoolDao
import com.globant.shared.data.model.*

@Database(
    entities = [
        SchoolEntity::class,
        StudentEntity::class,
        DirectorEntity::class,
        SubjectEntity::class,
        TeacherEntity::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao
}