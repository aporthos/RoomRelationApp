package com.globant.shared.domain.usecase

import com.globant.shared.data.Result
import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.StudentWithSubjectsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import com.globant.shared.domain.repository.SchoolRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentsOfSubjectsManyToManyUseCase @Inject constructor(
    private val repository: SchoolRepository
) : UseCase2<String, List<StudentWithSubjectsDto>>() {
    override suspend fun execute(parameters: String): Result<List<StudentWithSubjectsDto>> {
        return repository.getStudentsOfSubjects(parameters)
    }
}