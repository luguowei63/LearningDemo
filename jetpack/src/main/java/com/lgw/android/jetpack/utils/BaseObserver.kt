package com.lgw.android.jetpack.utils

import com.lgw.android.jetpack.bean.BaseResponse
import io.reactivex.Observer

/**
 *Created by lgw on 1/28/21
 */
abstract class BaseObserver<T> : Observer<BaseResponse<T>> {

    companion object {
        private const val TAG = "BaseObserver"
        private const val SUCCESS_CODE = 200
    }

    override fun onNext(response: BaseResponse<T>) {
        //对基础数据进行统一处理
        if(response.res_code== SUCCESS_CODE){
           onSuccess(response.demo)
        }else{
            onFailure(null,response.err_msg)
        }
    }


    override fun onError(e: Throwable) {

        onFailure(e,RxExceptionUtil.exceptionHandler(e))

    }




    abstract  fun onSuccess(result:T)

    abstract fun  onFailure(e: Throwable?, errorMsg:String)





}