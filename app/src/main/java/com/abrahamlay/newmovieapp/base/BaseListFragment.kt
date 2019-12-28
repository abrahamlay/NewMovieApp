package com.abrahamlay.newmovieapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.abrahamlay.newmovieapp.R
import kotlinx.android.synthetic.main.movie_fragment.*

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
abstract class BaseListFragment<DATA, VM : BaseViewModel> : BaseFragment<VM>(),
    SwipeRefreshLayout.OnRefreshListener {

    protected var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null


    protected var mItemList: List<DATA>? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.movie_fragment, container, false)


    override fun onRefresh() {
        // TODO
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        refresh.setOnRefreshListener(this)

    }

    protected fun getRecyclerView(): RecyclerView {
        return rvList
    }


    abstract fun getLayoutManager(): RecyclerView.LayoutManager?

    open fun showProgressBar(active: Boolean) {
        if (isAdded) {
            progressBarView.let {
                progressBarView.visibility = if (active) View.VISIBLE else View.GONE
            }
            refresh.let { refresh.isRefreshing = active }
        }
    }
}