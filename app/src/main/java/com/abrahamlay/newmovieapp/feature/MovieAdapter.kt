package com.abrahamlay.newmovieapp.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.newmovieapp.R
import com.abrahamlay.newmovieapp.constants.Constants.Companion.MOVIE_THUMBNAIL_BASE_URL_LARGE
import com.abrahamlay.newmovieapp.constants.Constants.Companion.MOVIE_THUMBNAIL_BASE_URL_MEDIUM
import com.abrahamlay.newmovieapp.databinding.ItemMovieBinding
import com.abrahamlay.newmovieapp.util.DateFormater
import com.abrahamlay.newmovieapp.util.GlideHelper
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Abraham Lay on 2019-10-13.
 */
class MovieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemMovieBinding.bind(inflater.inflate(R.layout.item_movie, viewGroup, false))
        return MovieItemViewHolder(binding.root)
    }

    var data: List<MovieModel>? = null

    var onClickListener: OnClickListener? = null

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as MovieItemViewHolder).bindData(data!![pos])
        (viewHolder as MovieItemViewHolder).setOnClickListener(View.OnClickListener {
            onClickListener?.onItemClicked(
                data!![pos]
            )
        })
    }

    interface OnClickListener {
        fun onItemClicked(data: Any)
    }

    inner class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvReleaseDate: TextView = itemView.tvReleaseDate
        private val tvDesc: TextView = itemView.tvDesc
        private val ivMovie: ImageView = itemView.ivMovie
        private val tvTitle: TextView = itemView.tvTitle

        fun bindData(item: MovieModel) {
            val url = String.format(MOVIE_THUMBNAIL_BASE_URL_MEDIUM, item.backdropPath)
            tvTitle.text = item.title

            GlideHelper.showImage(url, ivMovie, itemView.context)
            tvDesc.text = item.overview

            val releaseDate = DateFormater.changeDateFormat(
                "yyyy-MM-dd",
                item.releaseDate!!,
                "EEEE,  MMM dd, yyyy"
            )
            tvReleaseDate.text = releaseDate
        }

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }
}