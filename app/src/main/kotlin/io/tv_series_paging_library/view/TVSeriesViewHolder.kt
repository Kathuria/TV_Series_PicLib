package io.tv_series_paging_library.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.tv_series_paging_library.data.room.TVSeries
import kotlinx.android.synthetic.main.item_tv_series.view.image

class TVSeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun render(tvSeries: TVSeries) = itemView.run {
        Glide.with(image.context).load(tvSeries.posterUrl).into(image)
    }

    fun clear() = itemView.run {
        image.invalidate()
    }
}
