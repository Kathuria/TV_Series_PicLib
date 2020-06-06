package io.tv_series_paging_library.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.tv_series_paging_library.data.room.DATABASE.DATABASE_TV_SERIES
import io.tv_series_paging_library.data.room.DATABASE.DATABASE_TV_SERIES_VERSION

@Database(entities = [TVSeries::class], version = DATABASE_TV_SERIES_VERSION, exportSchema = false)
abstract class TVSeriesDatabase : RoomDatabase() {

    abstract fun tvSeriesDao(): TVSeriesDao

    companion object {

        @Volatile
        private var INSTANCE: TVSeriesDatabase? = null

        fun getInstance(context: Context): TVSeriesDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildTVSeriesDatabase(context).also { INSTANCE = it }
        }

        private fun buildTVSeriesDatabase(context: Context) =
                Room.databaseBuilder(context, TVSeriesDatabase::class.java, DATABASE_TV_SERIES).build()
    }
}
