package com.easycoder.product_view_with_dagger.data.main

import android.annotation.SuppressLint
import android.content.Context
import com.easycoder.product_view_with_dagger.core.interfaces.RequestCompleteListener
import com.easycoder.product_view_with_dagger.data.dataSource.networksource.ReportNetworkSource
import com.easycoder.product_view_with_dagger.di.annotation.ApplicationContext
import com.easycoder.product_view_with_dagger.utlis.GeneralHelper
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject


/**
 * Created by HM SHOHRAB on 24,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
class MainRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val reportNetworkSource: ReportNetworkSource
) : MainRepository {

    @SuppressLint("CheckResult")
    override fun getReportList(listenter: RequestCompleteListener<JSONObject>) {

        if (GeneralHelper.isNetConnected(context)){
        reportNetworkSource.getReport().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ value ->
                run {
                    var jo: JSONObject
                    try {
                        jo = JSONObject(value.string())
                    } catch (e: JSONException) {
                        jo = JSONObject()
                        e.printStackTrace()
                    }
                    if (jo.length() > 0) Logger.d("jsonObject", jo.toString())
                    listenter.onRequestSuccess(jo)
                    value.close()
                }

            },

                { error -> error.let { listenter.onRequestFailed(error.localizedMessage) } },
                { Logger.d("Completed") })

        }else{
            listenter.onRequestFailed("Please Check Your Internet Connection!")
        }


/*
        reportNetworkSource.getReport().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<ResponseBody> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    RxJavaDisposableManager.add(d)
                }


                override fun onError(e: Throwable) {

                }


                override fun onSuccess(t: ResponseBody) {
                    var jo: JSONObject
                    try {
                        jo = JSONObject(t.string())
                    } catch (e: JSONException) {
                        jo = JSONObject()
                        e.printStackTrace()
                    }
                    if (jo.length() > 0) Logger.d("jsonObject", jo.toString())
                    listenter.onRequestSuccess(jo)
                    t.close()
                }

            })*/


    }


}