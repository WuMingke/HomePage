package com.erkuai.homepage

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.erkuai.homepage.adapter.TabPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_home.setOnClickListener(this)
        tv_dynamic.setOnClickListener(this)

        cs_vp.adapter = TabPagerAdapter(supportFragmentManager, getTabs(), getFragments())
        cs_vp.addOnPageChangeListener(this)
      //  cs_layout.stickyOffset = 100

        ll_first_title.post{
            cs_vp.adjustHeight = ll_first_title.height
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_home -> {
                tv_home.setBackgroundResource(R.drawable.left_click_bg)
                tv_dynamic.setBackgroundResource(R.drawable.right_unclick_bg)
                cs_vp.currentItem = 0
            }
            R.id.tv_dynamic -> {
                tv_home.setBackgroundResource(R.drawable.left_unclick_bg)
                tv_dynamic.setBackgroundResource(R.drawable.right_click_bg)
                cs_vp.currentItem = 1
            }
        }
    }

    private fun getTabs(): List<String>? {
        val tabs: MutableList<String> = ArrayList()
        tabs.add("Tab1")
        tabs.add("Tab2")
        return tabs
    }

    private fun getFragments(): List<Fragment>? {
        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(HomeFragment())
        fragmentList.add(DynamicFragment())
        return fragmentList
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        if (position == 0) {
            tv_home.setBackgroundResource(R.drawable.left_click_bg)
            tv_dynamic.setBackgroundResource(R.drawable.right_unclick_bg)
        } else {
            tv_home.setBackgroundResource(R.drawable.left_unclick_bg)
            tv_dynamic.setBackgroundResource(R.drawable.right_click_bg)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }
}