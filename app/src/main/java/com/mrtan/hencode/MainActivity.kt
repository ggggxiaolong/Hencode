package com.mrtan.hencode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.ArrayList

import kotlinx.android.synthetic.main.activity_main.pager as mPager
import kotlinx.android.synthetic.main.activity_main.tabLayout as mTabLayout

class MainActivity : AppCompatActivity() {
  private lateinit var data: ArrayList<PageModel>
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initData()
    mPager.adapter = object :FragmentStatePagerAdapter(supportFragmentManager) {
      override fun getItem(position: Int): Fragment = PagerFragment.newInstance(data[position].sampleLayoutRes, data[position].practiceLayoutRes)

      override fun getCount(): Int = data.size

      override fun getPageTitle(position: Int): CharSequence = getString(data[position].titleRes)
    }

    mTabLayout.setupWithViewPager(mPager)
  }

  private fun initData() {
    data = ArrayList(11)
    data.apply {
      add(PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.cust_color))
      add(PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.cust_circle))
      add(PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.cust_rect))
      add(PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.cust_point))
      add(PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.cust_oval))
      add(PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.cust_line))
      add(PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.cust_round_rect))
      add(PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.cust_arc))
      add(PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.cust_path))
      add(PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.cust_histogram))
      add(PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.cust_pie_chart))
    }
  }

  private data class PageModel(@LayoutRes val sampleLayoutRes: Int, @StringRes val titleRes: Int, @LayoutRes val practiceLayoutRes: Int)
}
