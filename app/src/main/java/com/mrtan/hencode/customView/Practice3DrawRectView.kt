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
class Practice3DrawRectView : View {
  lateinit var mPaint: Paint
  var viewWidth: Int = 0
  var viewHeight: Int = 0
  var DP_80 = 0

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    DP_80 = context.dp2px(80)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    viewHeight = h
    viewWidth = w
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    //        练习内容：使用 canvas.drawRect() 方法画矩形
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL
    val centerX = viewWidth / 2
    val centerY = viewHeight / 2
    canvas.drawRect((centerX - DP_80).toFloat(), (centerY - DP_80).toFloat(),
        (centerX + DP_80).toFloat(),
        (centerY + DP_80).toFloat(), mPaint)
  }
}