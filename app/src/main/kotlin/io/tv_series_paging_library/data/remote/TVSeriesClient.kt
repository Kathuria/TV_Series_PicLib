package io.tv_series_paging_library.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.tv_series_paging_library.data.remote.Api.THE_TV_SERIES_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun getService(): TVSeriesService = createRetrofit().create(TVSeriesService::class.java)

private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(THE_TV_SERIES_URL)
        .addConverterFactory(GsonConverterFactory.create(gsonDeserializer()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(provideOkHttpClient())
        .build()

private fun gsonDeserializer(): Gson = GsonBuilder()
        .registerTypeAdapter(object : TypeToken<List<@JvmSuppressWildcards TVSeriesApi>>() {}.type, TVSeriesDeserializer<TVSeriesApi>())
        .setLenient()
        .create()

fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
