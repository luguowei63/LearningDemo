package com.lgw.android.testmodule.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 *Created by lgw on 1/14/21
 */
class Sweep(context: Context, attrs: AttributeSet?) : View(context, attrs) {



    constructor(context: Context):this(context,null)

    var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var mRotate: Float = 0f
    var mMatrix = Matrix()
    var mShader: Shader
    var paint = Paint()

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        val x = 160f
        val y = 100f
        mShader = SweepGradient(x, y, intArrayOf(Color.GREEN, Color.RED, Color.GRAY), null)
        mPaint.shader = mShader
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val x = 160f
        val y = 160f
        canvas!!.translate(300f, 300f)
        canvas.drawColor(Color.WHITE)
        matrix.setRotate(mRotate,x,y)
        mShader.setLocalMatrix(mMatrix)
        mRotate+=3
        if (mRotate>=360){
            mRotate=0f
        }
        invalidate()
        canvas.drawCircle(x,y,380f,paint)


    }


}