package io.tv_series_paging_library.data.remote

import com.google.gson.annotations.SerializedName
import io.tv_series_paging_library.data.remote.Api.IMAGES_URL
import io.tv_series_paging_library.data.room.TVSeries

data class TVSeriesApi(@SerializedName("id") val id: Int,
                    @SerializedName("title") val title: String,
                    @SerializedName("popularity") val popularity: Int,
                    @SerializedName("vote_average") val voteAverage: Int,
                    @SerializedName("poster_path") val posterPath: String,
                    @SerializedName("overview") val overview: String)

fun TVSeriesApi.toSeriesEntity() =
        TVSeries(id.toLong(), title ?: "Not Available", popularity, getVoteAverage(voteAverage), getPosterURL(posterPath?: "Not Available"), overview)

private fun getVoteAverage(voteAverage: Int) = voteAverage * 10

private fun getPosterURL(posterPath: String) = IMAGES_URL + posterPath

