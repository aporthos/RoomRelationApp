package com.globant.shared.domain.usecase

import com.globant.shared.R
import com.globant.shared.data.datasource.local.relations.SchoolAndDirector
import com.globant.shared.domain.repository.SchoolRepository
import com.globant.shared.data.Result
import com.globant.shared.domain.model.SchoolAndDirectorDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import kotlin.jvm.Throws
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetOneToOneUseCase @Inject constructor(
    private val repository: SchoolRepository
) : UseCase2<Unit, List<SchoolAndDirectorDto>>() {
    override suspend fun execute(parameters: Unit): Result<List<SchoolAndDirectorDto>> =
        repository.getSchoolAndDirector()
}


abstract class UseCase2<in P, R>() {
    suspend operator fun invoke(parameters: P): Result<R> = execute(parameters)

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): Result<R>
}

abstract class UseCase3<in P, R>() {
    suspend operator fun invoke(parameters: P): R = execute(parameters)

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}