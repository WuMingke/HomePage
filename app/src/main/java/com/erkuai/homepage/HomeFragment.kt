package com.erkuai.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.erkuai.homepage.adapter.TabPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.cs_vp
import java.util.ArrayList

class HomeFragment : Fragment(), View.OnClickListener, ViewPager.OnPageChangeListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_gift_wall.setOnClickListener(this)
        tv_gift_suit.setOnClickListener(this)

        cs_vp.adapter = TabPagerAdapter(childFragmentManager, getTabs(), getFragments())
        cs_vp.addOnPageChangeListener(this)

        ll_second_title.post{
            cs_vp.adjustHeight = ll_second_title.height
        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_gift_wall -> {
                tv_gift_wall.setBackgroundResource(R.drawable.left_click_bg)
                tv_gift_suit.setBackgroundResource(R.drawable.right_unclick_bg)
                cs_vp.currentItem = 0
            }
            R.id.tv_gift_suit -> {
                tv_gift_wall.setBackgroundResource(R.drawable.left_click_bg)
                tv_gift_suit.setBackgroundResource(R.drawable.right_unclick_bg)
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
        fragmentList.add(GiftWallFragment())
        fragmentList.add(GiftSuitFragment())
        return fragmentList
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        if (position == 0) {
            tv_gift_wall.setBackgroundResource(R.drawable.left_click_bg)
            tv_gift_suit.setBackgroundResource(R.drawable.right_unclick_bg)
        } else {
            tv_gift_wall.setBackgroundResource(R.drawable.left_unclick_bg)
            tv_gift_suit.setBackgroundResource(R.drawable.right_click_bg)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }
}