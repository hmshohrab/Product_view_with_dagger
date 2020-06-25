package com.easycoder.product_view_with_dagger.di.component

import android.app.Application
import com.easycoder.product_view_with_dagger.core.ui.BaseApplication
import com.easycoder.product_view_with_dagger.di.module.AppModule
import com.easycoder.product_view_with_dagger.di.module.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by HM SHOHRAB on 22,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */

@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, MainModule::class])
@Singleton
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

}