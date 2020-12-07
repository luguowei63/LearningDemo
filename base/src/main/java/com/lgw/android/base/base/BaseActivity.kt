package com.lgw.android.base.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lgw.android.base.interfaces.LifeCycleListener
import com.lgw.android.common.utils.canGoClick

/**
 *Created by lgw on 2020/11/11
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var mTag: String = BaseActivity::class.java.simpleName

    protected val mContext by lazy { this }

    protected lateinit var mLifeCycleListeners: MutableList<LifeCycleListener>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        mLifeCycleListeners = mutableListOf()
        main(savedInstanceState)
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onCreate()
            }
        }

    }

//    protected fun setTitle(title: String) {
//     var view=   findViewById<TextView>(R.id.tv_title);
//        view?.text = title
//    }
//
//    protected fun setBackClick() {
//        findViewById<View>(R.id.btn_back)?.setOnClickListener {
//            onBackPressed()
//        }
//    }

    protected fun canClick(): Boolean {
        return canGoClick()
    }

    protected abstract fun setLayoutId(): Int

    protected fun main(savedInstanceState: Bundle?) {
        main()
    }

    protected fun main() {

    }


    override fun onStart() {
        super.onStart()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onStart()
            }
        }
    }


    override fun onResume() {
        super.onResume()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onResume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onPause()
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onRestart()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onStop()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mLifeCycleListeners.size > 0) {
            for (listener in mLifeCycleListeners) {
                listener.onDestroy()
            }
        }
    }

    fun addLifeCycleListener(listener: LifeCycleListener?) {
        listener?.run { mLifeCycleListeners.add(this) }
    }

    fun removeLifeCycleListener(listener: LifeCycleListener?) {
        listener?.run { mLifeCycleListeners.remove(this) }
    }


    inline fun <reified T> startActivity(context: Context) {
        var intent = Intent(context, T::class.java)
        context.startActivity(intent)
    }

    inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
        var intent = Intent(context, T::class.java)
        intent.block()
        context.startActivity(intent)
    }

}