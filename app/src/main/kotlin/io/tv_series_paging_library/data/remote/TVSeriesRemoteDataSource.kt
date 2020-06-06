package io.tv_series_paging_library.data.remote

class TVSeriesRemoteDataSource(private val tvSeriesService: TVSeriesService) {

    fun fetchTVSeries(page: Int) = tvSeriesService.fetchTVSeries(page)
}
