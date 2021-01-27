package com.lgw.android.testmodule.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.lgw.android.testmodule.IMyAidlInterface;
import com.lgw.android.testmodule.service.PushService;

/**
 * Created by lgw on 1/26/21
 */
public class PushManager {

    private static final String TAG = "GEBILAOLITOU";
    private final int id = 1;


    private PushManager() {
    }

    private IMyAidlInterface iMyAidlInterface;


    private static final PushManager instance = new PushManager();

    public static PushManager getInstance() {
        return instance;
    }

    public void init(Context context){
        //定义intent
        Intent intent =new Intent(context, PushService.class);
        //绑定服务
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }



    public void connect() {
        try {
            //通过AIDL远程调用
            Log.d(TAG, "pushManager ***************start Remote***************");
            iMyAidlInterface.connect();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void sendString(String str) {
        try {
            //通过AIDL远程调用
            Log.d(TAG, "pushManager ***************sendString***************");
            Message message=new Message();
            message.id=1L;
            message.content=str;
            message.time=System.currentTimeMillis();
            iMyAidlInterface.sendInMessage(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //成功链接
            Log.d(TAG, "pushManager ***************成功连接***************");

            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //断开连接调用
            Log.d(TAG, "pushManager ***************连接已经断开***************");
        }
    };


}
