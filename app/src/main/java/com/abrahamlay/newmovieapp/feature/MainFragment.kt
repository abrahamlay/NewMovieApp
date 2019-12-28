package com.abrahamlay.newmovieapp.feature

import com.abrahamlay.newmovieapp.R
import com.abrahamlay.newmovieapp.feature.popular.PopularMovieFragment
import com.abrahamlay.newmovieapp.feature.toprated.TopRatedMovieFragment

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
}