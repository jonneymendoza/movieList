package com.richards.jonathan.movielist.data


/**
 * generic class that is used to hold a value and its state. use for fetching data that takes a while to get
 *
 * reference : https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/vo/Resource.kt
 */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.Success, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.Error, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.Loading, data, null)
        }
    }
}
