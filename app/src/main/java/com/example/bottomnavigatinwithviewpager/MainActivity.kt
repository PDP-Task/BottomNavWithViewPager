package com.example.bottomnavigatinwithviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavigatinwithviewpager.adapter.ViewPagerAdapter
import com.example.bottomnavigatinwithviewpager.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter


        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuHome -> binding.viewPager.currentItem = 0
                R.id.menuCategory -> binding.viewPager.currentItem = 1
                R.id.menuBookMark -> binding.viewPager.currentItem = 2
                R.id.menuPerson -> binding.viewPager.currentItem = 3
            }
            true
        }
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }

    override fun onBackPressed() {
        if(binding.viewPager.currentItem != 0) {
            binding.viewPager.currentItem = 0
        } else {
            super.onBackPressed()
        }
    }
}