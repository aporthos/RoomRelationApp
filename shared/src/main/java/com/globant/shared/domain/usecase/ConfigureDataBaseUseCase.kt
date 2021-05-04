package com.globant.shared.domain.usecase

import com.globant.shared.data.Result
import com.globant.shared.domain.repository.SchoolRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfigureDataBaseUseCase @Inject constructor(private val repository: SchoolRepository) :
    UseCase3<Unit, Unit>() {
    override suspend fun execute(parameters: Unit) {
        repository.insertDirector()
        repository.insertSchool()
        repository.insertSubject()
        repository.insertStudent()
        repository.insertTeacher()
        repository.insertStudentSubjectCrossRef()
    }
}