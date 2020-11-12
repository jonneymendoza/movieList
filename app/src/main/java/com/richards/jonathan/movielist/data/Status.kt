package com.richards.jonathan.movielist.data

sealed class Status {
    object Error : Status()
    object Loading : Status()
    object Success : Status()
}