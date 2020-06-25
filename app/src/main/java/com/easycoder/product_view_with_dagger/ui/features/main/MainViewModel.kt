package com.easycoder.product_view_with_dagger.ui.features.main

import androidx.lifecycle.MutableLiveData
import com.easycoder.product_view_with_dagger.core.interfaces.RequestCompleteListener
import com.easycoder.product_view_with_dagger.core.ui.BaseViewModel
import com.easycoder.product_view_with_dagger.data.main.MainRepository
import com.easycoder.product_view_with_dagger.data.main.model.Report
import com.easycoder.product_view_with_dagger.utlis.Constants
import com.easycoder.product_view_with_dagger.utlis.U
import org.json.JSONObject
import javax.inject.Inject


/**
 * Created by HM SHOHRAB on 02,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) :
    BaseViewModel() {


    var report: MutableLiveData<MutableList<Report>> = MutableLiveData()
    var isError: MutableLiveData<String> = MutableLiveData()


    init {
        getReportBase()
    }

    private fun getReportBase() {
        loader.postValue(true)

        mainRepository.getReportList(object : RequestCompleteListener<JSONObject> {

            override fun onRequestFailed(errorMessage: String) {
                isError.postValue(errorMessage)
                loader.postValue(false)
            }

            override fun onRequestSuccess(data: JSONObject) {
                loader.postValue(false)
                val errorCode = U.getIntJ(data, Constants.KEY_ERROR)
                val errorReport = U.getStringJ(data, Constants.KEY_ERROR_REPORT)
                val reportData = U.getJSONArrayJ(data, Constants.KEY_REPORT)
                when (errorCode) {
                    Constants.HTTP.OK -> {

                        val reportList = Report.parseReports(reportData)
                        report.postValue(reportList)
                    }
                    else -> {
                        isError.postValue("Data not Found.")
                    }
                }
            }

        })

    }
}