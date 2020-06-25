package com.easycoder.product_view_with_dagger.core.data.network

import io.reactivex.Maybe
import io.reactivex.Observable
import retrofit2.Response


fun <T> Maybe<Response<T>>.onResponse(): Maybe<T> {
    return map {
        if (it.isSuccessful) {
            if (it.body() != null) {
                it.body()
            } else {
                throw Exception("Request Exception")
            }
        } else {
            throw Exception(it.message())
        }
    }
}

