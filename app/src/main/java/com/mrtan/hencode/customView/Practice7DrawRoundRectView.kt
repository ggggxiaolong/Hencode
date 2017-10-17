package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * @author mrtan on 10/17/17.
 */
class Practice7DrawRoundRectView : View {
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
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

  }
}