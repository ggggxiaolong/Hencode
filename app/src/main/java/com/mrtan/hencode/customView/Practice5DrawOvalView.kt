package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author mrtan on 10/17/17.
 */
class Practice5DrawOvalView : View {
  lateinit var mPaint: Paint
  var viewHeight: Int = 0
  var viewWidth: Int = 0
  var ovalW = 0F
  var ovalH = 0F

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
    ovalW = viewWidth / 4F
    ovalH = viewHeight / 8F
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        练习内容：使用 canvas.drawOval() 方法画椭圆
    mPaint.style = Paint.Style.FILL
    mPaint.color = Color.BLACK
    val centerX = viewWidth / 2
    val centerY = viewHeight / 2
    canvas.drawOval(centerX - ovalW, centerY - ovalH, centerX + ovalW, centerY + ovalH, mPaint)
  }
}