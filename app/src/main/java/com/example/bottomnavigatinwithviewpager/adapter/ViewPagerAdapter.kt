package com.example.bottomnavigatinwithviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bottomnavigatinwithviewpager.fragments.BookMarkFragment
import com.example.bottomnavigatinwithviewpager.fragments.CategoryFragment
import com.example.bottomnavigatinwithviewpager.fragments.HomeFragment
import com.example.bottomnavigatinwithviewpager.fragments.ProfileFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CategoryFragment()
            2 -> BookMarkFragment()
            3 -> ProfileFragment()
            else -> Fragment()
        }
    }
}