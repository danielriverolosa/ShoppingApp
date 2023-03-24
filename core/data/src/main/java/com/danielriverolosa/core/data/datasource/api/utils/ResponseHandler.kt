package com.danielriverolosa.core.data.datasource.api.utils

import com.danielriverolosa.core.domain.error.RepositoryException
import retrofit2.Response

inline fun <reified T, R> Response<R>.handleResponse(block: (R?) -> T): T {
    if (isSuccessful) {
        return block(body())
    } else {
        throw RepositoryException("Bad request error")
    }
}