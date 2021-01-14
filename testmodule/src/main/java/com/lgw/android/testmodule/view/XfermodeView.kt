package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lgw.android.testmodule.R

/**
 *Created by lgw on 1/14/21
 */
class XfermodeView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var mContext: Context = context
    var mPaint=Paint()

    constructor(context: Context) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //原始图片
        val src = BitmapFactory.decodeResource(mContext.resources, R.mipmap.test2)
        //图片的遮罩
        val  mask=BitmapFactory.decodeResource(mContext.resources, R.mipmap.test3)
        /**
         * 分析
         * 当前的模式是相交出绘制目标图像，那么我们的src就是目标图像了，mask是遮罩，反正是不会被绘制的，理解来看应该是原始图像
         */

        /**
         * 将绘制操作保存致新的图层(更官方的说法应该是离屏缓存)
         */
        var  sc=canvas!!.saveLayer(0f,0f,720f,1080f,null,Canvas.ALL_SAVE_FLAG)


        // 先绘制dis目标图
        canvas.drawBitmap(src, 0f,0f, mPaint);

        // 设置混合模式   （只在源图像和目标图像相交的地方绘制目标图像）
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

        // 再绘制src源图
        canvas.drawBitmap(mask, 180f, 200f, mPaint)

        // 还原混合模式
        mPaint.xfermode = null

        // 还原画布
        canvas.restoreToCount(sc)





















    }


}