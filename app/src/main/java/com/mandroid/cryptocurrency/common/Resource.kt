package com.mandroid.cryptocurrency.common

/**
 * Created by Manish Kumar on 28/06/22.
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String?, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data)
}