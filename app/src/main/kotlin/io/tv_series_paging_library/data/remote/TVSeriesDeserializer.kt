package io.tv_series_paging_library.data.remote

import com.google.gson.*
import java.lang.reflect.Type

class TVSeriesDeserializer<T> : JsonDeserializer<T> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): T = Gson().run {
        val tvSeriesJsonObject = json?.asJsonObject?.get("results")?.asJsonArray
        fromJson(tvSeriesJsonObject, typeOfT)
    }
}
