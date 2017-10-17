package com.mrtan.hencode

import android.content.Context

/**
 * @author mrtan on 10/17/17.
 */
fun Context.dp2px(dp: Int): Int {
  val density = resources.displayMetrics.density
  return (dp * density + 0.5f).toInt()
}