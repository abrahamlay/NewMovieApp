package com.abrahamlay.newmovieapp.feature.toprated

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.newmovieapp.feature.MovieAdapter
import com.abrahamlay.newmovieapp.feature.MovieFragment
import com.abrahamlay.newmovieapp.feature.ViewContract
import kotlinx.android.synthetic.main.movie_fragment.rvList
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 2019-10-06.
 */

class TopRatedMovieFragment : MovieFragment<TopRatedMovieViewModel>(),
    ViewContract,
    MovieAdapter.OnClickListener {
    override fun onRefresh() {
        showLoading()
        viewModel.refreshMovie()
    }


    override val viewModel by viewModel<TopRatedMovieViewModel>()


    override fun onInitObservers() {
        super.onInitObservers()
        adapter = MovieAdapter()
        (adapter as? MovieAdapter)?.onClickListener = this
        viewModel.movieData.observe(this, Observer {
            onMovieLoaded(it)
        })
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return LinearLayoutManager(context)
    }

    override fun onMovieLoaded(list: List<MovieModel>) {
        hideLoading()
        (adapter as? MovieAdapter)?.data = list
        rvList.adapter = adapter
        rvList.layoutManager = getLayoutManager()
    }

    override fun onItemClicked(data: Any) {
        Toast.makeText(context, (data as MovieModel).title, Toast.LENGTH_SHORT).show()
        //TODO add detail movie page with android navigation
    }
}