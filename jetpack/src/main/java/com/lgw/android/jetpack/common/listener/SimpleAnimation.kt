package com.lgw.android.jetpack.common.listener

import android.animation.Animator

/**
 *Created by lgw on 2020/12/10
 * 直接重写，避免以后使用的时候每次都要重写所有的方法
 */
class SimpleAnimation:Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator?) {
    }

    override fun onAnimationEnd(animation: Animator?) {
    }

    override fun onAnimationCancel(animation: Animator?) {
    }

    override fun onAnimationRepeat(animation: Animator?) {
    }
}