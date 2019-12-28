package com.abrahamlay.newmovieapp.feature

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Abraham Lay on 2019-12-28.
 */
internal class TabAdapter(
    private val items: List<Fragment>,
    private val titles: List<String>,
    childFragmentManager: FragmentManager
) : FragmentStatePagerAdapter(childFragmentManager) {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }

}
