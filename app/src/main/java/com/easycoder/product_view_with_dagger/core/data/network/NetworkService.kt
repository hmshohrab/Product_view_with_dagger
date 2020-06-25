package com.easycoder.product_view_with_dagger.core.data.network

import android.content.Context
import com.easycoder.product_view_with_dagger.data.dataSource.networksource.ReportNetworkService
import io.reactivex.MaybeObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response


/**
 * Created by HM SHOHRAB on 22,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
object NetworkService {
    enum class API {
        REPORT
    }

    fun execute(
        context: Context, api: API, params: Array<Any>?, onSuccess: (jo: JSONObject) -> Unit,
        onFailure: ((ste: Throwable?) -> Unit)? = null
    ) {
        val retrofit = RestApiClient.getRetrofit(context)
        val call = when (api) {
            API.REPORT -> retrofit.create(ReportNetworkService::class.java).callApiForReport()

        }

        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<Response<ResponseBody>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    RxJavaDisposableManager.add(d)
                }


                override fun onError(e: Throwable) {
                    onFailure?.invoke(e)
                }


                override fun onSuccess(t: Response<ResponseBody>) {

                    var jo: JSONObject
                    try {
                        jo = JSONObject(t.body()?.string() ?: "")
                    } catch (e: JSONException) {
                        jo = JSONObject()
                        e.printStackTrace()
                    }
                    if (jo.length() > 0) com.orhanobut.logger.Logger.d("jsonObject", jo.toString())
                    onSuccess(jo)
                    t.body()?.close()
                }

            })

    }

/*    fun execute(context: Context, onSuccess: (jo: JSONObject) -> Unit,
                onFailure: ((ste: Throwable?) -> Unit)? = null) {


        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<Response<ResponseBody>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    RxJavaDisposableManager.add(d)
                }


                override fun onError(e: Throwable) {
                    onFailure?.invoke(e)
                }



                override fun onSuccess(t: Response<ResponseBody>) {

                    var jo: JSONObject
                    try {
                        jo = JSONObject(t.body()?.string() ?: "")
                    } catch (e: JSONException) {
                        jo = JSONObject()
                        e.printStackTrace()
                    }
                    if (jo.length() > 0) com.orhanobut.logger.Logger.d("jsonObject", jo.toString())
                    onSuccess(jo)
                    t.body()?.close()                }

            })

    }*/

}