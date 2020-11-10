package com.lgw.android.common.http.base;


import com.lgw.android.common.http.utils.RxExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

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
        onFailure(e, RxExceptionUtil.INSTANCE.exceptionHandler(e));
    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(Throwable e,String errorMsg);







}
