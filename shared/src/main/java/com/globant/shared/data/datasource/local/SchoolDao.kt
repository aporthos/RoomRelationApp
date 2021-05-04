package com.globant.shared.data.datasource.local

import androidx.room.*
import com.globant.shared.data.datasource.local.relations.*
import com.globant.shared.data.model.*

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(schoolEntity: List<SchoolEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(directorEntity: List<DirectorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(directorEntity: DirectorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(studentEntity: List<StudentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(student: List<SubjectEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacherEntity: List<TeacherEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: List<StudentSubjectCrossRef>)

    @Transaction
    @Query("SELECT * FROM SchoolEntity")
    suspend fun getSchoolAndDirector(): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM SchoolEntity WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM SubjectEntity WHERE subjectName = :subjectName")
    suspend fun getSubjectsOfStudents(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM StudentEntity WHERE studentName = :studentName")
    suspend fun getStudentsOfSubjects(studentName: String): List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM TeacherEntity")
    suspend fun getTeacherWithStudentAndSubjects(): List<TeacherWithStudentAndSubjects>

}