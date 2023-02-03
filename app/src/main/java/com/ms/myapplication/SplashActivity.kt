package com.ms.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.ms.myapplication.Adapter.ViewPagerAdapter

class SplashActivity : AppCompatActivity() {

    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var tabLayout : TabLayout
    private lateinit var viewPager: ViewPager
    lateinit var nextButton: Button

    lateinit var images : Array<Int>

    var viewPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tabLayout = findViewById(R.id.tabIndicator)
        setViewPagerAdapter()

        viewPosition = viewPager.currentItem

        nextButton = findViewById(R.id.splashNextButton)

        // Next Button Listener

        nextButton.setOnClickListener {
            if (viewPosition < images.size)
            {
                viewPosition++
                if (viewPosition == 3) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                viewPager.currentItem = viewPosition
            }
        }

        // Tab Layout Listener

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPosition = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewPosition = tab!!.position

            }
        })
    }

    // Set Dummy Splash Images

    private fun setViewPagerAdapter() {
         images = arrayOf(
            R.drawable.splashslideimage1,
            R.drawable.splashslideimage2,
            R.drawable.splashslideimage2
        )

        viewPager = findViewById(R.id.splashViewPager)
        viewPagerAdapter = ViewPagerAdapter(images, this)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}