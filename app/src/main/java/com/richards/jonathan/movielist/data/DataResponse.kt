package com.richards.jonathan.movielist.data

interface  DataResponse<T>{
    fun getResponseData(): T
}