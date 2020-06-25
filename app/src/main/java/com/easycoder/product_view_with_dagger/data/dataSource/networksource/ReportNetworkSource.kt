package com.easycoder.product_view_with_dagger.data.dataSource.networksource

import io.reactivex.Maybe
import okhttp3.ResponseBody

interface ReportNetworkSource {

    fun getReport(): Maybe<ResponseBody>
}