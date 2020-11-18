package com.lgw.android.base.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import com.lgw.android.base.interfaces.LifeCycleListener
import com.lgw.android.common.utils.canGoClick

/**
 *Created by lgw on 2020/11/11
 */
abstract class BaseView(context: Context, parentView: ViewGroup) : LifeCycleListener {
    protected val mTag: String = BaseView::class.java.simpleName

    protected var mContext: Context = context


    protected var mParentView: ViewGroup? = parentView
    protected var mContentView: View?


    init {
        mContentView = LayoutInflater.from(mContext).inflate(setLayoutId(), mParentView, false)
        init()
    }


    constructor(context: Context, parentView: ViewGroup, vararg args: Any) :this(context,parentView){
        mContext = context
        processArguments(args)
        mParentView = parentView
        mContentView = LayoutInflater.from(mContext).inflate(setLayoutId(), mParentView, false)
        init()
    }


    protected fun processArguments(vararg args: Any) {}

    protected abstract fun init()


    protected abstract fun setLayoutId(): Int

    protected fun canClick(): Boolean {
        return canGoClick()
    }

    protected fun addToParent() {
        if (mParentView != null && mContentView != null) {
            mParentView!!.addView(mContentView)
        }
    }

    protected fun removeFromParent() {
        var parent: ViewParent? = mContentView!!.parent
        parent?.let {
            (it as ViewGroup).removeView(mContentView)
        }
    }

    /**
     * 订阅Activity的生命周期
     */
    fun subscribeActivityLifeCycle() {
        if (mContext is BaseActivity) {
            (mContext as BaseActivity).addLifeCycleListener(this)
        }
    }

    /**
     * 取消订阅Activity的生命周期
     */

    fun unSubscribeActivityLifeCycle() {
        if (mContext is BaseActivity) {
            (mContext as BaseActivity).removeLifeCycleListener(this)
        }
    }

    /**
     * 释放资源
     */
    open fun release() {
    }


    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onRestart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }
}