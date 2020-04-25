package com.abrahamlay.base.presentation

import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.abrahamlay.base.subscriber.BaseViewModel


/**
 * Created by abraham.lay01 on 7/26/2019.
 */
abstract class BaseListFragment<DATA, VM : BaseViewModel> : BaseFragment<VM>(),
    SwipeRefreshLayout.OnRefreshListener {

    protected var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null
    protected var mItemList: List<DATA>? = null

}