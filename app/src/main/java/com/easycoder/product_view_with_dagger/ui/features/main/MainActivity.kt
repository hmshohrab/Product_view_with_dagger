package com.easycoder.product_view_with_dagger.ui.features.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.easycoder.product_view_with_dagger.R
import com.easycoder.product_view_with_dagger.core.interfaces.SimpleCallback
import com.easycoder.product_view_with_dagger.core.ui.DaggerBaseActivity
import com.easycoder.product_view_with_dagger.data.main.model.Report
import com.easycoder.product_view_with_dagger.ui.features.report.ReportViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerBaseActivity<MainViewModel>() {
    var reportAdapter: ReportAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRecyclerView()

        // viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]


    }


    override fun observeViewModelEvents() {
        super.observeViewModelEvents()
        viewModel.loader.observe(this) {
            pb_home.visibility = if (it) View.VISIBLE else View.GONE
        }


        viewModel.report.observe(this) {
            reportAdapter?.submitList(it)

        }

        viewModel.isError.observe(this){
            showErrorSnack(it)
        }
    }

    private fun setRecyclerView() {
        rc_report.layoutManager = LinearLayoutManager(this)
        reportAdapter =
            ReportAdapter(
                mutableListOf()
            )
        rc_report.adapter = reportAdapter

        reportAdapter!!.setListener(SimpleCallback<Report> {
            val bundle = Bundle()
            bundle.putSerializable("REPORT", it)
            startActivity(ReportViewActivity::class.java, bundle)
        })

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
