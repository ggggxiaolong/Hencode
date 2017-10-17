package com.mrtan.hencode.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.mrtan.hencode.dp2px
import java.text.NumberFormat

/**
 * @author mrtan on 10/17/17.
 */
class Practice10HistogramView : View {
  lateinit var mPaint: Paint
  lateinit var mTextPaint: TextPaint
  lateinit var items: ArrayList<Item>
  lateinit var percentFormat: NumberFormat

  var alexX: Float = 0F //x坐标轴起点
  var alexY: Float = 0F //y坐标轴起点
  var height: Float = 0F //直方图的高度
  var width: Float = 0F  //直方图的宽度
  var dividerW: Float = 0F //间隔
  var textSize: Float = 0F //x轴字体大小
  var itemW: Float = 0F  //item的宽度
  var leftH: Float = 0F  //剩余的高度

  constructor(context: Context) : this(context, null)
  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context)
  }

  private fun init(context: Context) {
    mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    mTextPaint.color = Color.WHITE
    mTextPaint.textAlign = Paint.Align.CENTER
    items = ArrayList(8)
    items.apply {
      add(Item("GB", 0.006F))
      add(Item("ICS", 0.006F))
      add(Item("JB", 0.066F))
      add(Item("KitKat", 0.145F))
      add(Item("L", 0.277F))
      add(Item("M", 0.32F))
      add(Item("N", 0.178F))
      add(Item("O", 0.002F))
    }

    percentFormat = NumberFormat.getPercentInstance()
    percentFormat.maximumFractionDigits = 2
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    alexX = w * 0.1F
    alexY = h * 0.7F
    height = h * 0.6F
    width = w * 0.8F
    dividerW = width / 34
    textSize = dividerW
    itemW = dividerW * 3
    leftH = h * 0.3F
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    mPaint.color = Color.WHITE
    val dp_1 = context.dp2px(1).toFloat()
    mPaint.strokeWidth = dp_1
    mTextPaint.textSize = textSize

    //画坐标轴
    canvas.drawLine(alexX, alexY, alexX, alexY - height, mPaint)
    canvas.drawLine(alexX, alexY, alexX + width, alexY, mPaint)
    //画图形和坐标
    var startX = alexX
    mPaint.color = Color.GREEN
    mPaint.style = Paint.Style.FILL
    items.forEach {
      startX += dividerW
      val itemH = height * it.value
      canvas.drawRect(startX, alexY - itemH, startX + itemW, alexY - dp_1 / 2, mPaint)
      canvas.drawText(it.title, (startX + startX + itemW) / 2, alexY + textSize, mTextPaint)
      canvas.drawText(percentFormat.format(it.value), (startX + startX + itemW) / 2,
          alexY - textSize - itemH, mTextPaint)
      startX += itemW
    }

    //画标题
    mTextPaint.textSize = textSize * 2
    canvas.drawText("直方图", alexX + width / 2, alexY + leftH / 2 , mTextPaint)
  }

  data class Item(val title: String, val value: Float)
}