// IMyAidlInterface.aidl
package com.lgw.android.testmodule;

import com.lgw.android.testmodule.aidl.Message;

interface IMyAidlInterface {
    //连接
       void connect();

       void sendInMessage(in Message message);
}