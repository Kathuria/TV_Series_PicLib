package io.tv_series_paging_library.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import io.tv_series_paging_library.data.repository.TVSeriesRepository
import io.tv_series_paging_library.data.room.TVSeries
import io.reactivex.disposables.CompositeDisposable

class TVSeriesViewModel(private val tvSeriesRepository: TVSeriesRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _pagedListSeries = MutableLiveData<PagedList<TVSeries>>()
    var pagedListSeries = _pagedListSeries

    fun getTVSeries() {
        compositeDisposable.add(tvSeriesRepository.fetchOrGetTVSeries().subscribe({ _pagedListSeries.value = it }, { it.printStackTrace() }))
    }

    override fun onCleared() {
        super.onCleared()
        tvSeriesRepository.disposable()?.run { compositeDisposable.add(this) }
        compositeDisposable.dispose()
    }
}
