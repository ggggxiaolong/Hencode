package com.mrtan.hencode

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub

/**
 * @author mrtan on 10/17/17.
 */
class PagerFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View {
    val view = layoutInflater.inflate(R.layout.frag_main, container, false)
    //初始化实例
    val sampleStub: ViewStub = view.findViewById(R.id.sampleStub)
    sampleStub.layoutResource = arguments.getInt(TAG_SAMPLE_RES)
    sampleStub.inflate()
    //初始化自定义
    val practice: ViewStub = view.findViewById(R.id.practiceStub)
    practice.layoutResource = arguments.getInt(TAG_PRACTICE_RES)
    practice.inflate()

    return view
  }

  companion object {
    private val TAG_SAMPLE_RES = "PagerFragment.sampleRes"
    private val TAG_PRACTICE_RES = "PagerFragment.practiceRes"
    fun newInstance(@LayoutRes sampleRes: Int, @LayoutRes practiceRes: Int): PagerFragment {
      val fragment = PagerFragment()
      val args = Bundle()
      args.apply {
        putInt(TAG_SAMPLE_RES, sampleRes)
        putInt(TAG_PRACTICE_RES, practiceRes)
      }
      fragment.arguments = args
      return fragment
    }
  }
}