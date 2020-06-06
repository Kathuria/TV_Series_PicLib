package io.tv_series_paging_library.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.tv_series_paging_library.data.room.DATABASE.TABLE_TV_SERIES

@Entity(tableName = TABLE_TV_SERIES)
data class TVSeries(@PrimaryKey val id: Long,
                 val title: String,
                 val popularity: Int,
                 val voteAverage: Int,
                 val posterUrl: String,
                 val description: String)
