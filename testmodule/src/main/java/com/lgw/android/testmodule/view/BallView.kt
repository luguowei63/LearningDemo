package com.lgw.android.testmodule.view

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.lgw.android.common.utils.getScreenHeight
import com.lgw.android.common.utils.getScreenWidth

/**
 *Created by lgw on 2020/12/23
 */
class BallView(activity: Context, attributeSet: AttributeSet?) : View(activity, attributeSet) {


    private val screenWidth = getScreenWidth(activity as Activity)
    private val screenHeight = getScreenHeight(activity as Activity)
    private val halfWidth = screenWidth / 2f
    private val halfHeight = screenHeight / 2f
    private var locationX = halfWidth
    private val radius = 30f
    private val locationRightX = screenWidth - radius
    private val locationLeftX = radius
    private val paint = Paint()
    private var goRight = true

    constructor(activity: Context) : this(activity, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        canvas?.drawCircle(locationX, halfHeight, radius, paint)

        if (goRight) {
            locationX += 5
        } else {
            locationX -= 5
        }
        if (locationX == locationRightX) {
            goRight = false
        }
        if (locationX == locationLeftX) {
            goRight = true
        }

    }


}