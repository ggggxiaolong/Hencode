package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * @author mrtan on 10/17/17.
 */
class Practice2DrawCircleView : View {
  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {

  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    //        练习内容：使用 canvas.drawCircle() 方法画圆
    //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
  }
}