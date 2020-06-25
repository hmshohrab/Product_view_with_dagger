package com.easycoder.product_view_with_dagger.data.dataSource.networksource


import io.reactivex.Maybe
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ReportNetworkService {


    @GET("api/home_page.php")
    fun callApiForReport(): Maybe<Response<ResponseBody>>
}