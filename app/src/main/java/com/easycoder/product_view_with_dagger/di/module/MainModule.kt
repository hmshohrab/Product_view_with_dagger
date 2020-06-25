package com.easycoder.product_view_with_dagger.di.module

import android.content.Context
import androidx.lifecycle.ViewModel

import com.easycoder.product_view_with_dagger.core.data.network.RestApiClient
import com.easycoder.product_view_with_dagger.data.dataSource.networksource.ReportNetworkService
import com.easycoder.product_view_with_dagger.data.dataSource.networksource.ReportNetworkSource
import com.easycoder.product_view_with_dagger.data.dataSource.networksource.ReportNetworkSourceImpl
import com.easycoder.product_view_with_dagger.data.main.MainRepository
import com.easycoder.product_view_with_dagger.data.main.MainRepositoryImpl
import com.easycoder.product_view_with_dagger.di.annotation.ApplicationContext
import com.easycoder.product_view_with_dagger.di.annotation.ViewModelKey
import com.easycoder.product_view_with_dagger.ui.features.main.MainActivity
import com.easycoder.product_view_with_dagger.ui.features.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton


/**
 * Created by HM SHOHRAB on 24,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
@Module
abstract class MainModule {


    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindMainRepository(repo: MainRepositoryImpl): MainRepository

    @Binds
    abstract fun bindNetworkSource(source: ReportNetworkSourceImpl): ReportNetworkSource

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideApiService(@ApplicationContext context: Context): ReportNetworkService {
            return RestApiClient.getRetrofit(context).create(ReportNetworkService::class.java)
        }

    }
}