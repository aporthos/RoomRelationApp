package com.globant.shared.data.repository

import com.globant.shared.data.Result
import com.globant.shared.data.Result.Error
import com.globant.shared.di.IoDispatcher
import com.globant.shared.domain.datasource.SchoolDataSource
import com.globant.shared.domain.model.SchoolAndDirectorDto
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import com.globant.shared.domain.repository.SchoolRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolRepositoryImpl @Inject constructor(
    private val schoolDataSource: SchoolDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SchoolRepository {
    override suspend fun getSchoolAndDirector(): Result<List<SchoolAndDirectorDto>> =
        withContext(ioDispatcher) {
            val local = schoolDataSource.getSchoolAndDirector()
            (local as? Result.Success)?.let {
//                if (it.data.isEmpty()) {
                return@withContext Result.Success(it.data)
//                }
            }
            return@withContext Error(Exception("Error fetching from remote and local"))
        }

    override suspend fun getSchoolWithStudents(schoolName: String): Result<List<SchoolWithStudentsDto>> =
        withContext(ioDispatcher) {
            val local = schoolDataSource.getSchoolWithStudents(schoolName)
            (local as? Result.Success)?.let {
                return@withContext Result.Success(it.data)
            }
            return@withContext Error(Exception("Error fetching from remote and local"))
        }

    override suspend fun getSubjectsOfStudents(schoolName: String): Result<List<SubjectWithStudentsDto>> =
        withContext(ioDispatcher) {
            val local = schoolDataSource.getSubjectsOfStudents(schoolName)
            (local as? Result.Success)?.let {
                return@withContext Result.Success(it.data)
            }
            return@withContext Error(Exception("Error fetching from remote and local"))
        }

    override suspend fun getStudentsOfSubjects(schoolName: String): Result<List<StudentWithSubjectsDto>> =
        withContext(ioDispatcher) {
            val local = schoolDataSource.getStudentsOfSubjects(schoolName)
            (local as? Result.Success)?.let {
                return@withContext Result.Success(it.data)
            }
            return@withContext Error(Exception("Error fetching from remote and local"))
        }

    override suspend fun insertDirector() {
        schoolDataSource.insertDirector()
    }

    override suspend fun insertSchool() {
        schoolDataSource.insertSchool()
    }

    override suspend fun insertSubject() {
        schoolDataSource.insertSubject()
    }

    override suspend fun insertStudent() {
        schoolDataSource.insertStudent()
    }

    override suspend fun insertTeacher() {
        schoolDataSource.insertTeacher()
    }

    override suspend fun insertStudentSubjectCrossRef() {
        schoolDataSource.insertStudentSubjectCrossRef()
    }
}