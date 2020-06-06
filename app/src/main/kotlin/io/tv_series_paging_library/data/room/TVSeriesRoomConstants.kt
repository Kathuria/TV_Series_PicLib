package io.tv_series_paging_library.data.room

object DATABASE {
    const val DATABASE_TV_SERIES = "tvSeries.db"
    const val DATABASE_TV_SERIES_VERSION = 1
    const val TABLE_TV_SERIES = "tvSeries"

    const val SELECT_TV_SERIES = "SELECT * FROM $TABLE_TV_SERIES ORDER BY popularity DESC, title ASC"

    const val PAGE_SIZE = 20
}
