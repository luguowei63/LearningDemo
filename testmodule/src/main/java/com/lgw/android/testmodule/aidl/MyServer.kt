package com.lgw.android.testmodule.aidl

import android.util.Log
import com.lgw.android.testmodule.IMyAidlInterface

/**
 *Created by lgw on 1/26/21
 */
class MyServer : IMyAidlInterface.Stub() {
    private val TAG = "GEBILAOLITOU"
    override fun connect() {
        Log.i(TAG, "MyServer connect");
    }

    override fun sendInMessage(message: Message?) {
        Log.i(TAG,"MyServer ** sendInMessage **"+message.toString());
    }


}