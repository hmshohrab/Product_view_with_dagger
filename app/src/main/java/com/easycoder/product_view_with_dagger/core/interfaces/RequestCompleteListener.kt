package com.easycoder.product_view_with_dagger.core.interfaces

interface RequestCompleteListener<T> {
    fun onRequestSuccess(data: T)
    fun onRequestFailed(errorMessage: String)
}