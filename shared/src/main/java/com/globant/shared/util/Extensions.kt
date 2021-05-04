package com.globant.shared.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.shared.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

inline fun ViewModel.executeUseCase(
    ioDispatcher: CoroutineDispatcher,
    crossinline block: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(ioDispatcher) {
        block()
    }
}

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <T> Result<T>.onFailure(action: (Exception) -> Unit) {
    if (this is Result.Error) action(exception)
}