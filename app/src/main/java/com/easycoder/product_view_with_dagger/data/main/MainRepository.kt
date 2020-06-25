package com.easycoder.product_view_with_dagger.data.main

import com.easycoder.product_view_with_dagger.core.interfaces.RequestCompleteListener
import org.json.JSONObject


/**
 * Created by HM SHOHRAB on 24,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
interface MainRepository {
    fun getReportList(listenter: RequestCompleteListener<JSONObject>)
}