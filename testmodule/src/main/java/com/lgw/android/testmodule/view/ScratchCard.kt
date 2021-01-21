package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.lgw.android.testmodule.R


/**
 *Created by lgw on 1/14/21
 */
class ScratchCard(context: Context, attributeSet: AttributeSet?) : View(context, attributeSet) {

    private var paint: Paint= Paint(Paint.ANTI_ALIAS_FLAG)
    private var dstBitmap: Bitmap? = null
    private var srcBitmap: Bitmap? = null
    private var realRewardBitmap: Bitmap? = null
    private var path: Path? = null
    private var touchX: Float? = null
    private var touchY: Float? = null
    private var dstCanvas:Canvas= Canvas()

    constructor(activity: Context) : this(activity, null)

    init {
    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        paint.color=Color.GREEN
        paint.style=Paint.Style.STROKE
        paint.strokeWidth=40f
//真实的奖励图

        //真实的奖励图
        realRewardBitmap = BitmapFactory.decodeResource(resources, R.mipmap.award, null)

        //原图，即要刮走的图
        srcBitmap = BitmapFactory.decodeResource(resources, R.mipmap.test2, null)

        //目标图
        dstBitmap = Bitmap.createBitmap(srcBitmap!!.width, srcBitmap!!.height, Bitmap.Config.ARGB_8888)

        path = Path()
        dstCanvas.setBitmap(dstBitmap)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path!!.moveTo(event.x, event.y)
                touchX = event.x
                touchY = event.y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (touchX!! + event.x) / 2
                val endY = (touchY!! + event.y) / 2
                path!!.quadTo(touchX!!, touchY!!, endX, endY)
                touchX = event.x
                touchY = event.y
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        invalidate()
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawBitmap(realRewardBitmap!!, 0f, 0f, paint)

        val count=canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null)

         dstCanvas.drawPath(path!!, paint)
        canvas.drawBitmap(dstBitmap!!, 0f, 0f, paint)

        paint.xfermode =  PorterDuffXfermode(PorterDuff.Mode.SRC_OUT); //设置图像混合模式
        canvas.drawBitmap(srcBitmap!!, 0f, 0f, paint); //将最上面的刮刮奖图片画到画布上

        paint.xfermode = null; //清空Xfermode
        canvas.restoreToCount(count);

    }


}