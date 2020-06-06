package io.tv_series_paging_library.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.tv_series_paging_library.data.repository.TVSeriesRepository

class TVSeriesViewModelFactory(private val tvSeriesRepository: TVSeriesRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = TVSeriesViewModel(tvSeriesRepository) as T
}
