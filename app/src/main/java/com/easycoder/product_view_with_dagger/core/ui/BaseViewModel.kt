package com.easycoder.product_view_with_dagger.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val loader = MutableLiveData<Boolean>()


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}