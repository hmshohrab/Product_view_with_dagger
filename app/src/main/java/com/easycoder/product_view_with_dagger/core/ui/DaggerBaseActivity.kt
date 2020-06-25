package com.easycoder.product_view_with_dagger.core.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class DaggerBaseActivity<VM : BaseViewModel> : DaggerAppCompatActivity(),
    BaseFragmentCommunicator {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: VM


    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass()]
        observeViewModelEvents()
        observeClickEvents()
        setUpView()


    }

    /**
     * Observes Rxview events when implemented
     */
    open fun observeClickEvents() {

    }

    /**
     * Used instead of onCreate
     */
    open fun setUpView() {

    }

    /**
     * Observes livedata from viewmodel
     */
    open fun observeViewModelEvents() {

    }

    override fun startActivity(clz: Class<*>?, bundle: Bundle?) {
        val intent = Intent(this, clz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    override fun showErrorSnack(message: String) {
        try {
            Snackbar.make(
                findViewById(android.R.id.content), message,
                Snackbar.LENGTH_LONG
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setupActionBar(toolbar: Toolbar, enableBackButton: Boolean) {
        setSupportActionBar(toolbar)
        if (enableBackButton) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
        }
    }

    private fun getViewModelClass(): Class<VM> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }

}
