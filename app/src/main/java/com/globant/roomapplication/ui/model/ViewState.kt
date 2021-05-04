package com.globant.roomapplication.ui.model

sealed class ViewState<out T : Any> {
    data class Success<out T : Any>(val data: T) : ViewState<T>()
    data class Error<out T : Any>(val error: Throwable) : ViewState<T>()
    object Loading : ViewState<Nothing>()
}