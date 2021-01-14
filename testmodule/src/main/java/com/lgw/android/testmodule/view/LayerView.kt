package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *Created by lgw on 1/14/21
 *
 *
 *Canvas提供了图层(Layer)支持，缺省的情况下可以看作只有一个图层Layer,如果需要按层次来绘图，
 *Android的 Canvas 可以使用SaverLayer ，Restore来创建一些中间层。
 * 创建一个新的layer 到栈中，可以使用savelayer，savelayerAlapha，从栈中推出一个Layer，可以使用restore，restoreToCount，但Layer入栈时，后续的DrawXXX操作都发生在这个Layer
 * 而Layer推栈时，就会吧本层绘制的图像会支到上层或者
 *
 *
 */
class LayerView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    var dst = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888)
    var src = dst.copy(Bitmap.Config.ARGB_8888, true)
    var b3 = Bitmap.createBitmap(450, 450, Bitmap.Config.ARGB_8888)
    var c1 = Canvas(dst)
    var c2 = Canvas(src)
    var c3 = Canvas(b3)
    var p1 = Paint()
    var p2 = Paint()
    var paint = Paint()

    constructor(context: Context) : this(context, null)

    init {
        p1.color = Color.GRAY
        c1.drawCircle(150f, 150f, 150f, p1)
        p2.color = Color.GREEN
        c2.drawRect(0f, 0f, 300f, 300f, p2)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画圆
        c3.drawBitmap(dst,0f,0f,null)
        //定义位图的运算模式
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC))

       canvas!!.drawBitmap(dst,0f,0f,null)
    }


}