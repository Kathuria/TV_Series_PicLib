package io.tv_series_paging_library.data.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import io.tv_series_paging_library.data.remote.TVSeriesRemoteDataSource
import io.tv_series_paging_library.data.room.DATABASE.PAGE_SIZE
import io.tv_series_paging_library.data.room.TVSeries
import io.tv_series_paging_library.data.room.TVSeriesRoomDataSource
import io.reactivex.Observable

class TVSeriesRepository(private val tvSeriesRemoteDataSource: TVSeriesRemoteDataSource, private val tvSeriesRoomDataSource: TVSeriesRoomDataSource) {
    private val PageListSeriesBoundaryCallback = PageListSeriesBoundaryCallback(tvSeriesRemoteDataSource, tvSeriesRoomDataSource)

    fun fetchOrGetTVSeries(): Observable<PagedList<TVSeries>> = RxPagedListBuilder(tvSeriesRoomDataSource.getTVSeries(), PAGE_SIZE)
            .setBoundaryCallback(PageListSeriesBoundaryCallback(tvSeriesRemoteDataSource, tvSeriesRoomDataSource))
            .buildObservable()

    fun disposable() = PageListSeriesBoundaryCallback.disposable
}
