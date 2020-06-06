package io.tv_series_paging_library.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import io.tv_series_paging_library.R
import io.tv_series_paging_library.data.room.TVSeries

class TVSeriesPagedListAdapter : PagedListAdapter<TVSeries, TVSeriesViewHolder>(tvSeriesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVSeriesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tv_series, parent, false)
        return TVSeriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TVSeriesViewHolder, position: Int) {
        val tvSeries = getItem(position)
        if (tvSeries != null) holder.render(tvSeries) else holder.clear()
    }

    companion object {
        private val tvSeriesDiffCallback = object : DiffUtil.ItemCallback<TVSeries>() {
            override fun areItemsTheSame(oldItem: TVSeries, newItem: TVSeries): Boolean {
                return oldItem.id == newItem.id && oldItem.title == newItem.title && oldItem.popularity == newItem.popularity &&
                        oldItem.voteAverage == newItem.voteAverage && oldItem.posterUrl == newItem.posterUrl &&
                        oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: TVSeries, newItem: TVSeries): Boolean {
                return oldItem == newItem
            }
        }
    }
}
