package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mrtan.hencode.dp2px

/**
 * @author mrtan on 10/17/17.
 */
class Practice6DrawLineView : View {

  lateinit var mPaint: Paint
  var viewHeight: Int = 0
  var viewWidth: Int = 0

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init()
  }

  private fun init() {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    viewHeight = h
    viewWidth = w
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        练习内容：使用 canvas.drawLine() 方法画直线
    val lineW = viewWidth / 4
    val lineH = viewHeight / 4
    val centerX = viewWidth / 2
    val centerY = viewHeight / 2
    mPaint.strokeWidth = context.dp2px(2).toFloat()
    canvas.drawLine((centerX - lineW).toFloat(), (centerY - lineH).toFloat(),
        (centerX + lineW).toFloat(), (centerY + lineH).toFloat(), mPaint)
  }
}