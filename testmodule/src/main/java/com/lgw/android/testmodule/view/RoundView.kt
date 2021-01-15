package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lgw.android.testmodule.R

/**
 *Created by lgw on 1/15/21
 */
class RoundView(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {


    private var bitmapAward = BitmapFactory.decodeResource(context.resources, R.mipmap.test2)
    private var bitmapWidth = bitmapAward.width

    private var bitmapHeight = bitmapAward.height

    private var bitmapMask =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888, true)
    private var canvasMask = Canvas(bitmapMask)
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)


    constructor(activity: Context) : this(activity, null)

    init {
        canvasMask.drawCircle(bitmapWidth / 2f, bitmapHeight / 2f, bitmapWidth / 2f, mPaint)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 保存画布
        // 先画一次原文字
//        canvas.drawBitmap(mTextBitmap, 0, 0, mPaint);
        // 保存画布
        val sc = canvas!!.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)
        canvas.drawBitmap(bitmapAward, 0f, 0f, mPaint)
        mPaint.xfermode = xfermode

        canvas.drawBitmap(bitmapMask, 0f, 0f, mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(sc)
    }


}