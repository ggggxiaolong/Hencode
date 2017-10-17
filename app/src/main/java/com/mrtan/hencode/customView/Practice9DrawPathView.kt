package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * @author mrtan on 10/17/17.
 */
class Practice9DrawPathView : View {
  lateinit var mPaint: Paint
  lateinit var mPath: Path

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init()
  }

  private fun init() {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    mPath = Path()
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    val centerX = w / 2
    val centerY = h / 2
    val minValue = Math.min(w, h)
    val baseValue = minValue / 48
    mPath.arcTo((centerX - baseValue * 6).toFloat(), (centerY - baseValue * 4).toFloat(), centerX.toFloat(),
        (centerY + baseValue * 2).toFloat(), 140F, 220F, true)
    mPath.arcTo(centerX.toFloat(), (centerY - baseValue * 4).toFloat(),
        (centerX + baseValue * 6).toFloat(),
        (centerY + baseValue * 2).toFloat(), 180F, 220F, false)
    mPath.lineTo(centerX.toFloat(), (centerY + baseValue * 7).toFloat())
    mPath.close()
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        练习内容：使用 canvas.drawPath() 方法画心形
    mPaint.color = Color.BLACK
    mPaint.style = Paint.Style.FILL
    canvas.drawPath(mPath, mPaint)
  }
}