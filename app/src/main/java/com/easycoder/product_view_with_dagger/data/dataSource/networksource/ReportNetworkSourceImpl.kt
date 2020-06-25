package com.easycoder.product_view_with_dagger.data.dataSource.networksource


import com.easycoder.product_view_with_dagger.core.data.network.onResponse
import io.reactivex.Maybe
import okhttp3.ResponseBody
import javax.inject.Inject

class ReportNetworkSourceImpl @Inject constructor(private val networkService: ReportNetworkService) :
    ReportNetworkSource {
    override fun getReport(): Maybe<ResponseBody> {
        return networkService.callApiForReport().onResponse()
    }

}