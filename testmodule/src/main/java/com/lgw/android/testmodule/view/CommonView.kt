package com.lgw.android.testmodule.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.lgw.android.common.utils.L
import com.lgw.android.common.utils.getScreenHeight
import com.lgw.android.common.utils.getScreenWidth
import kotlin.math.cos
import kotlin.math.sin

/**
 *Created by lgw on 2020/12/23
 */
class CommonView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {
    constructor(context: Context) : this(context, null)

    private val paint = Paint()
    private val screenWidth = getScreenWidth(context as Activity)
    private val screenHeight = getScreenHeight(context as Activity)
    private val halfWidth = screenWidth / 2f
    private val halfHeight = screenHeight / 2f
    private val RADIOUS = 400f

    private val SECOND_LENGTH = 250f
    private val MINUTE_LENGTH = 200f
    private val HOUR_LENGTH = 150f
    private val SECOND = 1
    private val MINUTE = SECOND * 60.toDouble()
    private val HOUR = 60 * MINUTE.toDouble()
    private val Day = 12 * HOUR.toDouble()
    private var secondsInMinute = 0.toDouble()
    private var secondsInHour = 0.toDouble()
    private var minutes = 1
    private var hours = 1
    private val SECOND_DEGREE = 6f
    private val HOUR_DEGREE = 30f
    var startCount = false


    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        paint.color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas!!.rotate(10f,0f,0f)
//        //第一张照片
//        canvas.drawBitmap(bitmap,0f,0f,paint)
//        //保存上一张画布
//        canvas.save()
//
//        canvas.rotate(10f,0f,0f)
//
//        canvas.drawBitmap(bitmap,halfWidth,halfHeight,paint)
//        //恢复至标准坐标轴
//        canvas.restore()
//
//
//        canvas.drawBitmap(bitmap,halfWidth,halfHeight,paint)

//        canvas!!.save()
//        for (index in 0..10) {
//            canvas.drawRect(0f, 0f, 150f, 150f, paint)
//            canvas.translate(30f, 30f)
//        }
//        //恢复save前坐标轴
//        canvas.restore()
//
//        canvas.translate(0f, halfHeight)
//        canvas.save()
//        for (index in 0..10) {
//            canvas.drawRect(
//                0f + index * 10,
//                0f + index * 10,
//                150f - index * 10,
//                150f - index * 10,
//                paint
//            )
//        }
//
//        canvas.restore()
//
//        canvas.translate(500f, 400f)
        //绘制表盘
        paint.color = Color.BLACK
        canvas!!.drawCircle(halfWidth, halfHeight, RADIOUS, paint)
        canvas.translate(halfWidth, halfHeight)
        //绘制时钟刻度
        canvas.save()
        for (index in 0..12) {
            paint.strokeWidth = 4f
            paint.color = Color.BLACK
            canvas.drawLine(300f, 0f, RADIOUS, 0f, paint)
            canvas.rotate(HOUR_DEGREE)
        }
        canvas.restore()
        canvas.save()
        //绘制分钟刻度
        for (index in 0..60) {
            paint.strokeWidth = 2f
            paint.color = Color.BLACK
            canvas.drawLine(350f, 0f, RADIOUS, 0f, paint)
            canvas.rotate(SECOND_DEGREE)
        }
        canvas.restore()
        canvas.rotate(-90f)
        canvas.save()
        if (!startCount) {
            //绘制秒针
            paint.color = Color.RED
            canvas.drawLine(0f, 0f, SECOND_LENGTH, 0f, paint)
            //绘制分针
            canvas.restore()
            canvas.save()
            paint.color = Color.GREEN
            canvas.drawLine(0f, 0f, MINUTE_LENGTH, 0f, paint)
            //绘制时针
            canvas.restore()
            canvas.save()
            paint.color = Color.YELLOW
            canvas.drawLine(0f, 0f, HOUR_LENGTH, 0f, paint)
            canvas.restore()
        } else {
            //处理秒针,分针,时针的转动逻辑
            if (secondsInMinute == MINUTE) {
                secondsInMinute = 0.toDouble()
                minutes++
            }
            if (minutes == 60) {
                minutes = 0
                hours++
            }
            if (secondsInHour == HOUR) {
                secondsInHour = 0.toDouble()
            }
            if (hours == 12) {
                hours = 0
            }
            secondsInMinute++
            secondsInHour++
            //绘制秒针
            paint.color = Color.RED
            val secondDegree = secondsInMinute * SECOND_DEGREE * 2 * Math.PI / 360
            canvas.drawLine(
                0f,
                0f,
                (SECOND_LENGTH * cos(secondDegree)).toFloat(),
                (SECOND_LENGTH * sin(secondDegree)).toFloat(),
                paint
            )

            //绘制分针
            val minuteDegree =
                (secondsInMinute / MINUTE  * minutes + (minutes - 1) )* SECOND_DEGREE * 2 * Math.PI / 360
            if (minuteDegree!=0.toDouble()) {
                paint.color = Color.GREEN
                canvas.drawLine(
                    0f,
                    0f,
                    MINUTE_LENGTH * cos(minuteDegree).toFloat(),
                    MINUTE_LENGTH * sin(minuteDegree).toFloat(),
                    paint
                )
            }
            //绘制时针

            val hourDegree =
                (secondsInHour / HOUR  * hours + (hours - 1) ) * HOUR_DEGREE* 2 * Math.PI / 360
            if (hourDegree!=0.toDouble()) {
                paint.color = Color.YELLOW
                canvas.drawLine(
                    0f,
                    0f,
                    HOUR_LENGTH * cos(hourDegree).toFloat(),
                    HOUR_LENGTH * sin(hourDegree).toFloat(),
                    paint
                )
            }
        }
    }

}