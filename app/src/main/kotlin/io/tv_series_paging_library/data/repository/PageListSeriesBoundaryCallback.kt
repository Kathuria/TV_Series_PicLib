package io.tv_series_paging_library.data.repository

import android.util.Log
import androidx.paging.PagedList
import io.tv_series_paging_library.data.remote.TVSeriesRemoteDataSource
import io.tv_series_paging_library.data.remote.toSeriesEntity
import io.tv_series_paging_library.data.room.TVSeries
import io.tv_series_paging_library.data.room.TVSeriesRoomDataSource
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PageListSeriesBoundaryCallback(private val tvSeriesRemoteDataSource: TVSeriesRemoteDataSource,
                                    private val tvSeriesRoomDataSource: TVSeriesRoomDataSource) : PagedList.BoundaryCallback<TVSeries>() {

    private var isRequestRunning = false
    private var requestedPage = 1
    var disposable: Disposable? = null

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")
        fetchAndStoreTVSeries()
    }

    override fun onItemAtEndLoaded(itemAtEnd: TVSeries) {
        Log.i(TAG, "onItemAtEndLoaded")
        fetchAndStoreTVSeries()
    }

    private fun fetchAndStoreTVSeries() {
        if (isRequestRunning) return
        isRequestRunning = true
        disposable = tvSeriesRemoteDataSource.fetchTVSeries(requestedPage)
                .map { TVSeriesApiList -> TVSeriesApiList.map { it.toSeriesEntity() } }
                .doOnSuccess { listSeries ->
                    if (listSeries.isNotEmpty()) {
                        tvSeriesRoomDataSource.storeTVSeries(listSeries)
                        Log.i(TAG, "Inserted: ${listSeries.size}")
                    } else {
                        Log.i(TAG, "No Inserted")
                    }
                    requestedPage++
                }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .ignoreElement()
                .doFinally { isRequestRunning = false }
                .subscribe({ Log.i(TAG, "TVSeries Completed") }, { it.printStackTrace() })

    }

    companion object {
        private const val TAG: String = "PageListSeriesBoundary "
    }
}
