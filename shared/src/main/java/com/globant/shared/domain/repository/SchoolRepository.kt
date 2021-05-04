package com.globant.shared.domain.repository

import com.globant.shared.data.datasource.local.relations.SchoolAndDirector
import com.globant.shared.data.Result
import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.domain.model.SchoolAndDirectorDto
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto

interface SchoolRepository {
    suspend fun getSchoolAndDirector(): Result<List<SchoolAndDirectorDto>>
    suspend fun getSchoolWithStudents(schoolName: String): Result<List<SchoolWithStudentsDto>>
    suspend fun getSubjectsOfStudents(schoolName: String): Result<List<SubjectWithStudentsDto>>
    suspend fun getStudentsOfSubjects(schoolName: String): Result<List<StudentWithSubjectsDto>>
    suspend fun insertDirector()
    suspend fun insertSchool()
    suspend fun insertSubject()
    suspend fun insertStudent()
    suspend fun insertTeacher()
    suspend fun insertStudentSubjectCrossRef()
}