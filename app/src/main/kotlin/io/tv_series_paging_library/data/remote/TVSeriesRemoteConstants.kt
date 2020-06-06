package io.tv_series_paging_library.data.remote

object Api {
    const val THE_TV_SERIES_URL = "https://api.themoviedb.org/3/"
    const val IMAGES_URL = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
}

object Endpoint {
    const val DISCOVER = "discover/tv"
}

object Query {
    const val API_KEY = "api_key"
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val LANGUAGE = "language"
    const val INCLUDE_ADULT = "include_adult"

    const val SORT_BY_DEFAULT = "popularity.desc"
    const val LANGUAGE_DEFAULT = "en-US"
    const val INCLUDE_ADULT_DEFAULT = false

    // Please create your own key, its free. Keeping as may be required for quick glance
    const val API_KEY_VALUE = "63fbdcfdd4efd55280069d9e694cb38c"
}
