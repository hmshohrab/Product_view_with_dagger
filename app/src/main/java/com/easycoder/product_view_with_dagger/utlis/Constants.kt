package com.easycoder.product_view_with_dagger.utlis


import com.easycoder.product_view_with_dagger.BuildConfig

/**
 * @author shohrab
 * @date 05/12/2019
 */

object Constants {

    object HTTP {
        const val OK = 0
        const val OK_MAX = 209

        const val INVALID = 400
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val INVALID_MAX = 499
        const val HTTP_NOT_ACCEPTABLE = 406
        const val ERROR = 500
        const val BAD_GATEWAY = 502
        const val ERROR_MAX = 599

    }


    var MAIN_URL = BuildConfig.BASE_URL


    /**
     * For count-down formatting
     */
    val SECS_IN_DAY = 24 * 60 * 60
    val SECS_IN_HOUR = 60 * 60
    val SECS_IN_MINUTE = 60

    val KEY_DB = "DB"
    val KEY_URL = "_url"
    val KEY_ID = "_id"
    val KEY_NAME = "_name"


    /**
     * API Keys
     */
    val KEY_ERROR = "error"
    val KEY_REPORT = "report"
    val KEY_ERROR_REPORT = "error_report"
    val KEY_PAGINATION = "pagination"
    val KEY_MSG = "message"
    val KEY_TYPE = "type"
    val KEY_COUNT = "count"
    val KEY_SUCCESS = "success"
    val KEY_TOKEN = "api_token"
    val KEY_PROFILE = "profile"
    val KEY_CUR_PAGE = "current_page"

    //endregion

    //region Messages
    val API_ERROR_MESSAGE = "Network Error! Try again later."


}
