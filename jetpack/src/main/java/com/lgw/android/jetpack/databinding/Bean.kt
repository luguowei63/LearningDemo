package com.lgw.android.jetpack.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import com.lgw.android.jetpack.BR

/**
 *Created by lgw on 2/7/21
 */


data class UserBean(var name: String, var password: String)


class ObservableGoodsBean(name: String, details: String, price: Float) {
    val name = ObservableField(name)
    val details = ObservableField(details)
    val price = ObservableFloat(price)
}


class GoodsBean : BaseObservable() {

    @Bindable
    var name = ""
        set(value) {
            field = value
            //只更新本字段
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var detail = ""
        set(value) {
            field = value
            //更新所有字段
            notifyChange()
        }

    var price = 0F


    class ImageBean(url: String) {
        var url = ObservableField(url)
    }


}


















