package com.lgw.android.common.http.base;


import android.widget.TextView;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

import static com.lgw.android.common.http.utils.RxExceptionUtilKt.exceptionHandler;

/**
 * Created by lgw on 2020/11/10
 */
public abstract  class BaseObserver<T> implements Observer<BaseResponse<T>> {


    @Override
    public void onNext(@NonNull BaseResponse<T> baseResponse) {
       if(baseResponse.getCode()==200){
           onSuccess(baseResponse.getContent());
       }else{
           onFailure(null,baseResponse.getErrMsg());
       }


    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFailure(e, exceptionHandler(e));
    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(Throwable e,String errorMsg);







}
