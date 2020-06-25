package com.easycoder.product_view_with_dagger.core.ui

import android.os.Bundle
import androidx.appcompat.widget.Toolbar

interface BaseFragmentCommunicator {

    fun startActivity(clz: Class<*>?, bundle: Bundle?)
    fun setupActionBar(toolbar: Toolbar, enableBackButton: Boolean)
    fun showErrorSnack(message: String)

}