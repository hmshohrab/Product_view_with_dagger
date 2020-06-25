package com.easycoder.product_view_with_dagger.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.easycoder.product_view_with_dagger.di.ViewModelFactory
import com.easycoder.product_view_with_dagger.di.annotation.ApplicationContext
import dagger.Binds
import dagger.Module


/**
 * Created by HM SHOHRAB on 22,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}