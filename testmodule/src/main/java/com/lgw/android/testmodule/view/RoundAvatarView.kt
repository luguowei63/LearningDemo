package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.lgw.android.testmodule.R

/**
 *Created by lgw on 1/14/21
 */
class RoundAvatarView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var mContext: Context = context
    var mPaint = Paint()


    constructor(context: Context) : this(context, null)

    var bitmap: Bitmap
    var xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)

    init {

        bitmap = BitmapFactory.decodeResource(mContext.resources, R.mipmap.test2)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /**
         * 设置View的离屏缓冲。在绘图的时候新建一个“层”，所有的操作都在该层而不会影响该层以外的图像
         * 必须设置，否则设置的PorterDuffXfermode会无效，具体原因不明
         */
        canvas!!.drawBitmap(bitmap, (paddingLeft).toFloat(), (paddingTop).toFloat(), null)
        mPaint.xfermode = xfermode
        val radius= width.coerceAtMost(height) /2f
        canvas.drawCircle((width - paddingLeft) / 2f, (height - paddingTop) / 2f, radius, mPaint)


    }


}