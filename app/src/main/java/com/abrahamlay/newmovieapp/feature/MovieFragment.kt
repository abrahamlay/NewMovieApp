package com.abrahamlay.newmovieapp.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abrahamlay.base.subscriber.BaseViewModel
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.newmovieapp.databinding.MovieFragmentBinding

/**
 * Created by Abraham Lay on 2019-12-28.
 */
abstract class MovieFragment<VM : BaseViewModel> : BaseListFragment<MovieModel, VM>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MovieFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return LinearLayoutManager(context)
    }
}