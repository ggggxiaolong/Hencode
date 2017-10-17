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
class Practice2DrawCircleView : View {
  var viewHeight = 0
  var viewWidth = 0
  var radius = 0
  var centerX = 0
  var centerY = 0
  var DP_20 = 0
  var DP_1 = 0
  lateinit var mPaint: Paint

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    DP_20 = context.dp2px(20)
    DP_1 = context.dp2px(1)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    viewHeight = h
    viewWidth = w
    radius = Math.min(viewHeight, viewWidth)  / 4 - DP_20
    centerX = viewWidth / 2
    centerY = viewHeight / 2
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    //        练习内容：使用 canvas.drawCircle() 方法画圆
    //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
    //画第一个
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL
    val width = radius + DP_20
    canvas.drawCircle((centerX - width).toFloat(), (centerY - width).toFloat(),
        radius.toFloat(), mPaint)
    //画第二个
    mPaint.style = Paint.Style.STROKE
    mPaint.strokeWidth = DP_1.toFloat()
    canvas.drawCircle((centerX + width).toFloat(), (centerY - width).toFloat(),
        radius.toFloat(), mPaint)
    //画第三个
    mPaint.color = Color.BLUE
    mPaint.style = Paint.Style.FILL
    canvas.drawCircle((centerX - width).toFloat(), (centerY + width).toFloat(),
        radius.toFloat(), mPaint)
    //画第四个
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.STROKE
    mPaint.strokeWidth = DP_20.toFloat()
    canvas.drawCircle((centerX + width).toFloat(), (centerY + width).toFloat(),
        radius.toFloat(), mPaint)
  }
}