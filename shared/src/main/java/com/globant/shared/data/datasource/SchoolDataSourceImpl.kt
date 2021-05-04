package com.globant.shared.data.datasource

import com.globant.shared.data.Result
import com.globant.shared.data.Result.Error
import com.globant.shared.data.datasource.local.SchoolDao
import com.globant.shared.data.datasource.local.relations.SchoolAndDirector
import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.data.datasource.local.relations.StudentWithSubjects
import com.globant.shared.data.datasource.local.relations.SubjectWithStudents
import com.globant.shared.data.mapper.SchoolAndDirectorMapper
import com.globant.shared.di.IoDispatcher
import com.globant.shared.domain.Transform
import com.globant.shared.domain.datasource.SchoolDataSource
import com.globant.shared.domain.model.SchoolAndDirectorDto
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import com.globant.shared.mock.Factory.directors
import com.globant.shared.mock.Factory.schools
import com.globant.shared.mock.Factory.studentSubjectRelations
import com.globant.shared.mock.Factory.students
import com.globant.shared.mock.Factory.subjects
import com.globant.shared.mock.Factory.teacher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolDataSourceImpl @Inject constructor(
    private val schoolDao: SchoolDao,
    private val schoolAndDirectorMapper: Transform<List<SchoolAndDirector>, List<SchoolAndDirectorDto>>,
    private val schoolWithStudentsMapper: Transform<List<SchoolWithStudents>, List<SchoolWithStudentsDto>>,
    private val subjectsWithStudentListMapper: Transform<List<SubjectWithStudents>, List<SubjectWithStudentsDto>>,
    private val studentWithSubjectsListMapper: Transform<List<StudentWithSubjects>, List<StudentWithSubjectsDto>>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SchoolDataSource {
    override suspend fun getSchoolAndDirector(): Result<List<SchoolAndDirectorDto>> =
        withContext(ioDispatcher) {
            return@withContext try {
                val mapper =
                    schoolAndDirectorMapper.transform(schoolDao.getSchoolAndDirector())
                Result.Success(mapper)
            } catch (e: Exception) {
                Error(e)
            }
        }

    override suspend fun getSchoolWithStudents(schoolName: String): Result<List<SchoolWithStudentsDto>> =
        withContext(ioDispatcher) {
            return@withContext try {
                val mapper= schoolWithStudentsMapper.transform(schoolDao.getSchoolWithStudents(schoolName))
                Result.Success(mapper)
            } catch (e: Exception) {
                Error(e)
            }
        }

    override suspend fun getSubjectsOfStudents(schoolName: String): Result<List<SubjectWithStudentsDto>> =
        withContext(ioDispatcher) {
            return@withContext try {
                val mapper= subjectsWithStudentListMapper.transform(schoolDao.getSubjectsOfStudents(schoolName))
                Result.Success(mapper)
            } catch (e: Exception) {
                Error(e)
            }
        }

    override suspend fun getStudentsOfSubjects(schoolName: String): Result<List<StudentWithSubjectsDto>> =
        withContext(ioDispatcher) {
            return@withContext try {
                val mapper= studentWithSubjectsListMapper.transform(schoolDao.getStudentsOfSubjects(schoolName))
                Result.Success(mapper)
            } catch (e: Exception) {
                Error(e)
            }
        }

    override suspend fun insertDirector() = withContext(ioDispatcher) {
//        for (i in 1..10_000_000) {
//            Timber.i("insertDirector: $i")
//            val result = Director(
//                "Mike Litoris $i",
//                "Jake Wharton School"
//            )
//        }
        schoolDao.insertDirector(directors)
    }

    override suspend fun insertSchool() = withContext(ioDispatcher) {
        schoolDao.insertSchool(schools)
    }

    override suspend fun insertSubject() = withContext(ioDispatcher) {
        schoolDao.insertSubject(subjects)
    }

    override suspend fun insertStudent() = withContext(ioDispatcher) {
        schoolDao.insertStudent(students)
    }

    override suspend fun insertTeacher() = withContext(ioDispatcher) {
        schoolDao.insertTeacher(teacher)
    }

    override suspend fun insertStudentSubjectCrossRef() = withContext(ioDispatcher) {
        schoolDao.insertStudentSubjectCrossRef(studentSubjectRelations)
    }

}