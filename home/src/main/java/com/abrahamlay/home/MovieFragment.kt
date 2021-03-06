package com.abrahamlay.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.base.presentation.BaseListFragment
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.home.databinding.MovieFragmentBinding
import kotlinx.android.synthetic.main.movie_fragment.*

/**
 * Created by Abraham Lay on 2019-12-28.
 */
abstract class MovieFragment<VM : BaseViewModel> : BaseListFragment<MovieModel, VM>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MovieFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    protected fun getLayoutManager(): RecyclerView.LayoutManager? {
        return LinearLayoutManager(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        refresh.setOnRefreshListener(this)

    }

    protected fun getRecyclerView(): RecyclerView {
        return rvList
    }

    open fun showProgressBar(active: Boolean) {
        if (isAdded) {
            progressBarView.let {
                progressBarView.visibility = if (active) View.VISIBLE else View.GONE
            }
            refresh.let { refresh.isRefreshing = active }
        }
    }

    fun showLoading() {
        refresh.isRefreshing = true
    }

    fun hideLoading() {
        refresh.isRefreshing = false
    }

}