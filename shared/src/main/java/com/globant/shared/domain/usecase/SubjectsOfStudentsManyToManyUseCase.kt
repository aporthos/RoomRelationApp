package com.globant.shared.domain.usecase

import com.globant.shared.data.Result
import com.globant.shared.data.datasource.local.relations.SchoolWithStudents
import com.globant.shared.domain.model.SchoolWithStudentsDto
import com.globant.shared.domain.model.SubjectWithStudentsDto
import com.globant.shared.domain.repository.SchoolRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectsOfStudentsManyToManyUseCase @Inject constructor(
    private val repository: SchoolRepository
) : UseCase2<String, List<SubjectWithStudentsDto>>() {
    override suspend fun execute(parameters: String): Result<List<SubjectWithStudentsDto>> {
        return repository.getSubjectsOfStudents(parameters)
    }
}