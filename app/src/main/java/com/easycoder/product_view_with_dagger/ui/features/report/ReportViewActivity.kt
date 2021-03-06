package com.easycoder.product_view_with_dagger.ui.features.report

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.easycoder.product_view_with_dagger.BuildConfig
import com.easycoder.product_view_with_dagger.R
import com.easycoder.product_view_with_dagger.data.main.model.Report
import kotlinx.android.synthetic.main.activity_report_view.*

class ReportViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_view)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title = "Product Details"
        val reportBundle = intent.extras

        val report = reportBundle?.getSerializable("REPORT") as Report
        productView(report)


    }


    private fun productView(report: Report) {
        txtTitleId.text = report.title
        txtPriceId.text = report.price.toString() + " Tk "
        Glide.with(this).load(BuildConfig.BASE_URL + report.image).into(img1)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
