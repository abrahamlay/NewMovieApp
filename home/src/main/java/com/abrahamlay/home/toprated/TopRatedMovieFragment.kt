package com.abrahamlay.home.toprated

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.home.MovieAdapter
import com.abrahamlay.home.MovieFragment
import com.abrahamlay.home.R
import com.abrahamlay.home.ViewContract
import com.abrahamlay.home.detail.DetailFragment
import kotlinx.android.synthetic.main.movie_fragment.*
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


    override fun onMovieLoaded(list: List<MovieModel>) {
        hideLoading()
        (adapter as? MovieAdapter)?.data = list
        rvList.adapter = adapter
        rvList.layoutManager = getLayoutManager()
    }

    override fun onItemClicked(data: Any) {
        Toast.makeText(context, (data as MovieModel).title, Toast.LENGTH_SHORT).show()
        val bundle = bundleOf(Pair(DetailFragment.PARAM_DETAIL_MOVIE, (data as MovieModel)))
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
    }
}