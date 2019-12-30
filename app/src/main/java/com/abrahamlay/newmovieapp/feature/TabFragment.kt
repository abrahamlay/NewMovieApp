package com.abrahamlay.newmovieapp.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.abrahamlay.newmovieapp.R
import com.abrahamlay.base.presentation.BaseFragment
import com.abrahamlay.base.subscriber.BaseViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Abraham Lay on 2019-12-28.
 */
abstract class TabFragment : BaseFragment<BaseViewModel>() {

    private var tabLayout: TabLayout? = null
    private var pager: ViewPager? = null

    private var adapter: TabAdapter? = null
    protected var fragments: MutableList<Fragment> = mutableListOf()
    protected var titles: MutableList<String> = mutableListOf()

    protected abstract fun initFragmentAndTitle()

    override val viewModel by viewModel<BaseViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_tab, container, false)
        tabLayout = view.findViewById(R.id.tab)
        pager = view.findViewById(R.id.pager)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initFragmentAndTitle()
        initTabAndPager()
    }

    private fun initTabAndPager() {
        if (isAdded) {
            adapter = TabAdapter(fragments, titles, childFragmentManager)
            pager!!.adapter = adapter
            tabLayout!!.setupWithViewPager(pager)
            pager!!.offscreenPageLimit = fragments.size
        }
    }

}
