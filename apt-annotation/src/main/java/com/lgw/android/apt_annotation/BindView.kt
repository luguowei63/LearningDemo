package com.lgw.android.apt_annotation

/**
 *Created by lgw on 1/20/21
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.BINARY)
annotation class BindView(val value:Int)
