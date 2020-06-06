package io.tv_series_paging_library.data.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.tv_series_paging_library.data.room.DATABASE.SELECT_TV_SERIES

@Dao
interface TVSeriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvSeriesList: List<TVSeries>)

    @Query(SELECT_TV_SERIES)
    fun allTVSeries(): DataSource.Factory<Int, TVSeries>
}
