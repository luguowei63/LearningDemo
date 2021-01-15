package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lgw.android.testmodule.R
import kotlin.math.abs

/**
 *Created by lgw on 1/14/21
 */
class ScratchCard(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {


    private var bitmapAward = BitmapFactory.decodeResource(context.resources, R.mipmap.award)
    private var bitmapWidth = bitmapAward.width

    private var bitmapHeight = bitmapAward.height

    private var bitmapMask =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888, true)
    private var canvasMask = Canvas(bitmapMask)
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var awardStr = "刮开有奖"
    private var textHeight = 30f
    private var textLeftPadding = 130f
    private var textSize = 50f
    private var xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
    private var path = Path()

    //记录用户path每次的开始坐标值
    private var mLastX = 0
    private var mLastY = 0


   private var paint=Paint()

constructor(activity: Context) : this(activity, null)

    init {
        mPaint.color = Color.YELLOW
        mPaint.isAntiAlias = true
        mPaint.isDither = true
        mPaint.style = Paint.Style.FILL
        mPaint.strokeJoin = Paint.Join.ROUND //设置圆角
        mPaint.strokeCap = Paint.Cap.ROUND

        mPaint.strokeWidth = 60f //设置画笔宽度
        mPaint.textSize = textSize
        canvasMask.drawColor(Color.GRAY)
        canvasMask.drawText(awardStr, textLeftPadding, bitmapHeight / 2 - textHeight, mPaint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                //记录按下的时候的X和Y值，以便于之后移动的时候绘制
                mLastX = x
                mLastY = y
                path.moveTo(mLastX.toFloat(), mLastY.toFloat())
            }
            MotionEvent.ACTION_MOVE -> {
                //拿到用户移动的X绝对值，Y轴绝对值
                val dx: Int = abs(x - mLastX)
                val dy: Int = abs(y - mLastY)
                //用户滑动超过3像素才会改变，这个可以不做，做只是为了避免很频繁的响应而已。
                if (dx > 3 || dy > 3) {
                    path.lineTo(x.toFloat(), y.toFloat())
                }
                mLastX = x
                mLastY = y
            }
        }
        canvasMask.drawPath(path, mPaint)
        invalidate() //刷新UI
        return true
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        val sl = canvas!!.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        mPaint.style=Paint.Style.STROKE
        canvas!!.drawBitmap(bitmapAward, 0f, 0f, paint)

        paint.xfermode = xfermode
        canvas.drawBitmap(bitmapMask, 0f, 0f, paint)
//        mPaint.xfermode = null
//        canvas.restoreToCount(sl)
    }


}