package com.abrahamlay.newmovieapp.feature.popular

import android.widget.Toast
import androidx.lifecycle.Observer
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.newmovieapp.feature.MovieAdapter
import com.abrahamlay.newmovieapp.feature.MovieFragment
import com.abrahamlay.newmovieapp.feature.ViewContract
import kotlinx.android.synthetic.main.movie_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 2019-10-06.
 */

class PopularMovieFragment : MovieFragment<PopularMovieViewModel>(),
    ViewContract,
    MovieAdapter.OnClickListener {


    override val viewModel by viewModel<PopularMovieViewModel>()

    override fun onInitObservers() {
        super.onInitObservers()
        adapter = MovieAdapter()
        (adapter as? MovieAdapter)?.onClickListener = this
        viewModel.movieData.observe(this, Observer {
            onMovieLoaded(it)
        })
    }

    override fun onMovieLoaded(list: List<MovieModel>) {
        (adapter as? MovieAdapter)?.data = list
        rvList.adapter = adapter
        rvList.layoutManager = getLayoutManager()
    }

    override fun onItemClicked(data: Any) {
        Toast.makeText(context, (data as MovieModel).title, Toast.LENGTH_SHORT).show()
    }
}