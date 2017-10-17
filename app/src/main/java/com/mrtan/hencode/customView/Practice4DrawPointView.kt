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
class Practice4DrawPointView : View {

  lateinit var mPaint : Paint
  var viewHeight: Int = 0
  var viewWidth: Int = 0
  var DP_40 : Int = 0

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    DP_40 = context.dp2px(40)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    viewHeight = h
    viewWidth = w
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
    val centerX = viewWidth / 2
    val centerY = viewHeight /2
    mPaint.strokeCap = Paint.Cap.ROUND
    mPaint.color = Color.BLACK
    mPaint.strokeWidth = DP_40.toFloat()

    canvas.drawPoint((centerX - DP_40).toFloat(), centerY.toFloat(), mPaint)

    mPaint.strokeCap = Paint.Cap.SQUARE
    canvas.drawPoint((centerX + DP_40).toFloat(), centerY.toFloat(), mPaint)
  }
}