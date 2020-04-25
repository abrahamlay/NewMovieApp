package com.abrahamlay.home

import com.abrahamlay.base.presentation.TabFragment
import com.abrahamlay.base.subscriber.BaseViewModel

import com.abrahamlay.home.popular.PopularMovieFragment
import com.abrahamlay.home.toprated.TopRatedMovieFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 2019-12-28.
 */
class MainFragment : TabFragment() {
    override fun initFragmentAndTitle() {
        titles.add(getString(R.string.top_rated))
        titles.add(getString(R.string.popular))
        fragments.add(TopRatedMovieFragment())
        fragments.add(PopularMovieFragment())
    }

    override val viewModel by viewModel<BaseViewModel>()

}