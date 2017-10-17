package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.mrtan.hencode.dp2px

/**
 * @author mrtan on 10/17/17.
 */
class Practice7DrawRoundRectView : View {

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
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
    val w = viewWidth / 8
    val h = viewHeight / 8
    val radius = context.dp2px(8)
    val centerX = viewWidth / 2
    val centerY = viewHeight / 2
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL
    canvas.drawRoundRect((centerX - w).toFloat(), (centerY - h).toFloat(), (centerX + w).toFloat(),
        (centerY + h).toFloat(), radius.toFloat(),
        radius.toFloat(), mPaint)
  }
}