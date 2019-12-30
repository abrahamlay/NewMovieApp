package com.abrahamlay.newmovieapp.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.base.constants.Constants
import com.abrahamlay.base.util.GlideHelper
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.newmovieapp.R
import com.abrahamlay.newmovieapp.databinding.ItemMovieBinding

/**
 * Created by Abraham Lay on 2019-10-13.
 */
class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemMovieBinding.bind(inflater.inflate(R.layout.item_movie, viewGroup, false))
        return MovieItemViewHolder(binding)
    }

    var data: List<MovieModel>? = null

    var onClickListener: OnClickListener? = null

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as MovieItemViewHolder).itemMovieBinding.movieModel = data!![pos]
        viewHolder.setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClicked(
                data!![pos]
            )
        })
    }

    interface OnClickListener {
        fun onItemClicked(data: Any)
    }

    inner class MovieItemViewHolder(val itemMovieBinding: ItemMovieBinding) :
        RecyclerView.ViewHolder(itemMovieBinding.root) {

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                val addedUrl =
                    if (!url.contains("https://") || !url.contains("http://")) String.format(
                        Constants.MOVIE_THUMBNAIL_BASE_URL_LARGE,
                        url
                    ) else url
                GlideHelper.showImage(addedUrl, view, view.context)
            }
        }
    }
}