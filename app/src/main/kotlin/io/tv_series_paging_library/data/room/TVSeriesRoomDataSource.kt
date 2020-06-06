package io.tv_series_paging_library.data.room

class TVSeriesRoomDataSource(private val tvSeriesDao: TVSeriesDao) {

    fun storeTVSeries(tvSeriesList: List<TVSeries>) = tvSeriesDao.insert(tvSeriesList)

    fun getTVSeries() = tvSeriesDao.allTVSeries()
}
