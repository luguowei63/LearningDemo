package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lgw.android.testmodule.R

/**
 *Created by lgw on 1/15/21
 */
class ScratchCard1(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

    /*第一种方法*/
    private var mPath: Path? = null
    private var mOuterPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mCanvas: Canvas? = null
    private var mBitmap: Bitmap? = null

    //记录用户path每次的开始坐标值
    private var mLastX = 0
    private var mLastY = 0
    private var mOuterBitmap: Bitmap? = null


    private var xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)

    constructor(context: Context) : this(context, null)

    init {
        mOuterPaint.color = Color.RED
        mOuterPaint.isAntiAlias = true
        mOuterPaint.isDither = true
        mOuterPaint.strokeJoin = Paint.Join.ROUND //设置圆角
        mOuterPaint.strokeCap = Paint.Cap.ROUND
        mOuterPaint.style = Paint.Style.FILL
        mOuterPaint.strokeWidth = 60f //设置画笔宽度
        mOuterPaint.textSize=80f

        mPath = Path()
        mBitmap = BitmapFactory.decodeResource(resources, R.mipmap.award)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //初始化bitmap
        if (mOuterBitmap == null) {
            mOuterBitmap =
                Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888)
        }
        if (mCanvas == null) {
            mCanvas = Canvas(mOuterBitmap!!)
            mCanvas!!.drawColor(Color.parseColor("#c0c0c0"))
            mCanvas!!.drawText("刮开有奖", 100f, 100f, mOuterPaint)
        }

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
                mPath!!.moveTo(mLastX.toFloat(), mLastY.toFloat())
            }
            MotionEvent.ACTION_MOVE -> {
                //拿到用户移动的X绝对值，Y轴绝对值
                val dx = Math.abs(x - mLastX)
                val dy = Math.abs(y - mLastY)
                //用户滑动超过3像素才会改变，这个可以不做，做只是为了避免很频繁的响应而已。
                if (dx > 3 || dy > 3) {
                    mPath!!.lineTo(x.toFloat(), y.toFloat())
                }
                mLastX = x
                mLastY = y
            }
        }
        mCanvas!!.drawPath(mPath!!, mOuterPaint)
        invalidate() //刷新UI
        return true
    }

    override fun onDraw(canvas: Canvas) {

        mOuterPaint.style = Paint.Style.STROKE
        canvas.drawBitmap(mBitmap!!, 0f, 0f, null)
        mOuterPaint.xfermode = xfermode
        canvas.drawBitmap(mOuterBitmap!!, 0f, 0f, null)
        mOuterPaint.xfermode = null
    }

}