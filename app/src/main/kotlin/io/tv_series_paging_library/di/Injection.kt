package io.tv_series_paging_library.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.tv_series_paging_library.data.remote.TVSeriesRemoteDataSource
import io.tv_series_paging_library.data.remote.getService
import io.tv_series_paging_library.data.repository.TVSeriesRepository
import io.tv_series_paging_library.data.room.TVSeriesDatabase
import io.tv_series_paging_library.data.room.TVSeriesRoomDataSource
import io.tv_series_paging_library.viewmodel.TVSeriesViewModel
import io.tv_series_paging_library.viewmodel.TVSeriesViewModelFactory

private fun provideTVSeriesDatabase(context: Context): TVSeriesRoomDataSource =
        TVSeriesRoomDataSource(TVSeriesDatabase.getInstance(context).tvSeriesDao())

private fun provideTVSeriesRepository(context: Context) =
        TVSeriesRepository(TVSeriesRemoteDataSource(getService()), provideTVSeriesDatabase(context))

private fun provideTVSeriesViewModelFactory(context: Context): ViewModelProvider.Factory =
        TVSeriesViewModelFactory(provideTVSeriesRepository(context))

fun provideTVSeriesViewModel(appCompatActivity: AppCompatActivity) =
        ViewModelProvider(appCompatActivity, provideTVSeriesViewModelFactory(appCompatActivity)).get(TVSeriesViewModel::class.java)

