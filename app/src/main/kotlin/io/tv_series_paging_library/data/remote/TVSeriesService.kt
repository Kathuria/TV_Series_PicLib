package io.tv_series_paging_library.data.remote

import io.tv_series_paging_library.data.remote.Endpoint.DISCOVER
import io.tv_series_paging_library.data.remote.Query.API_KEY
import io.tv_series_paging_library.data.remote.Query.API_KEY_VALUE
import io.tv_series_paging_library.data.remote.Query.INCLUDE_ADULT
import io.tv_series_paging_library.data.remote.Query.INCLUDE_ADULT_DEFAULT
import io.tv_series_paging_library.data.remote.Query.LANGUAGE
import io.tv_series_paging_library.data.remote.Query.LANGUAGE_DEFAULT
import io.tv_series_paging_library.data.remote.Query.PAGE
import io.tv_series_paging_library.data.remote.Query.SORT_BY
import io.tv_series_paging_library.data.remote.Query.SORT_BY_DEFAULT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TVSeriesService {

    @GET(DISCOVER)
    fun fetchTVSeries(@Query(PAGE) page: Int,
                    @Query(SORT_BY) sortBy: String = SORT_BY_DEFAULT,
                    @Query(LANGUAGE) language: String = LANGUAGE_DEFAULT,
                    @Query(INCLUDE_ADULT) includeAdult: Boolean = INCLUDE_ADULT_DEFAULT,
                    @Query(API_KEY) apiKey: String = API_KEY_VALUE): Single<List<TVSeriesApi>>
}
