package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * @author mrtan on 10/17/17.
 */
class Practice8DrawArcView : View {
  lateinit var mPaint : Paint
  var viewWidth : Int = 0
  var viewHeight : Int = 0
  lateinit var rectF : RectF

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init()
  }

  private fun init() {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    rectF = RectF()
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    viewHeight = h
    viewWidth = w

    val centerX = viewWidth / 2
    val centerY = viewHeight / 2

    val arcW = viewWidth / 8
    val arcH = viewHeight / 8
    rectF.left = (centerX - arcW).toFloat()
    rectF.top = (centerY - arcH).toFloat()
    rectF.right = (centerX + arcW).toFloat()
    rectF.bottom = (centerY + arcH).toFloat()
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL

    canvas.drawArc(rectF,260F, 90F, true, mPaint);
    canvas.drawArc(rectF, 20F, 140F, false, mPaint);
    mPaint.style = Paint.Style.STROKE
    canvas.drawArc(rectF, 180F, 70F, false, mPaint);
  }
}