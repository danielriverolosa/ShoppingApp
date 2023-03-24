package com.danielriverolosa.core.domain.usecase

import com.danielriverolosa.core.domain.dispatcher.DefaultDispatcherProvider
import com.danielriverolosa.core.domain.dispatcher.DispatcherProvider
import com.danielriverolosa.core.domain.error.DomainException
import kotlinx.coroutines.withContext

abstract class UseCase<Type, in Params>(
    private val dispatcher: DispatcherProvider = DefaultDispatcherProvider()
) where Type : Any {

    protected abstract suspend fun run(params: Params): Type

    suspend operator fun invoke(params: Params): Result<Type> {
        return withContext(dispatcher.io) {
            try {
                Result.success(run(params))
            } catch (e: Exception) {
                Result.failure(DomainException(e.message.orEmpty()))
            }
        }
    }

    object None
}