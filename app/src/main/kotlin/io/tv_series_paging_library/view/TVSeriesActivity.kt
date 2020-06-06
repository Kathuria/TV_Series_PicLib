package io.tv_series_paging_library.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.tv_series_paging_library.R
import io.tv_series_paging_library.di.provideTVSeriesViewModel
import io.tv_series_paging_library.view.decorator.MarginDecoration
import io.tv_series_paging_library.viewmodel.TVSeriesViewModel
import kotlinx.android.synthetic.main.activity_tv_series.tv_series_recycler

class TVSeriesActivity : AppCompatActivity() {

    private lateinit var tvSeriesViewModel: TVSeriesViewModel
    private val tvSeriesPagedListAdapter by lazy { TVSeriesPagedListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_series)
        initRecycler()
        initViewModel()
        initObserver()
    }

    private fun initRecycler() {
        tv_series_recycler.apply {
            addItemDecoration(MarginDecoration(this@TVSeriesActivity))
            adapter = tvSeriesPagedListAdapter
        }
    }

    private fun initViewModel() {
        tvSeriesViewModel = provideTVSeriesViewModel(this)
        tvSeriesViewModel.getTVSeries()
    }

    private fun initObserver() {
        tvSeriesViewModel.pagedListSeries.observe(this, Observer {
            tvSeriesPagedListAdapter.submitList(it)
        })
    }
}
