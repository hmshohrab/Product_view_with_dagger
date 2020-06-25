package com.easycoder.product_view_with_dagger.data.main.model

import com.easycoder.product_view_with_dagger.utlis.U
import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable


/**
 * Created by HM SHOHRAB on 22,June,2020
 * easyCoder company,
 * Dhaka, Bangladesh.
 * hmshohrabpc@gmail.com
 * Let's start coding :)
 * Bismillah Hir Rahman Nir Raheem
 */
data class Report(

    @SerializedName("Id") val id: Int,
    @SerializedName("Title") val title: String,
    @SerializedName("Price") val price: Double,
    @SerializedName("Image") val image: String
) : Serializable {
    companion object {


        fun parseReports(ja: JSONArray): MutableList<Report> {
            val l = ja.length()
            val reportList = mutableListOf<Report>()
            (0 until l).mapTo(reportList) {
                parseReport(
                    ja.getJSONObject(it)
                )
            }
            return reportList
        }

        private fun parseReport(jo: JSONObject) =
            Report(
                U.getIntJ(jo, "Id"),
                U.getStringJ(jo, "Title"),
                U.getDoubleJ(jo, "Price"),
                U.getStringJ(jo, "Image")
            )

    }
}