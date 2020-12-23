package com.lgw.android.testmodule.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.lgw.android.common.utils.getScreenHeight
import com.lgw.android.common.utils.getScreenWidth

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

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        paint.color = Color.RED
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

        canvas!!.save()
        for (index in 0..10) {
            canvas.drawRect(0f, 0f, 150f, 150f, paint)
            canvas.translate(30f, 30f)
        }
        //恢复save前坐标轴
        canvas.restore()

        canvas.translate(0f, halfHeight)
        canvas.save()
        for (index in 0..10) {
            canvas.drawRect(
                0f + index * 10,
                0f + index * 10,
                150f - index * 10,
                150f - index * 10,
                paint
            )
        }

        canvas.restore()

        canvas.translate(500f, 400f)
        canvas.drawCircle(300f, 300f, 300f, paint)
        canvas.save()
        canvas.translate(300f, 300f)
        for (index in 0..12) {
            canvas.rotate(30f)
            canvas.drawLine(0f, 0f, 300f, 0f, paint)
        }
        canvas.restore()

    }

}