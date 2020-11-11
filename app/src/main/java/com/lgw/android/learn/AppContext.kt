package com.lgw.android.learn

import com.lgw.android.common.CommonApplication
import com.lgw.android.pullto.PullApplication

/**
 *Created by lgw on 2020/11/11
 */
class AppContext : CommonApplication() {
    override fun appInit() {
        registerApplication(PullApplication::class.java)
    }
}