package com.lgw.android.common;

import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgw on 2020/11/11
 */
public abstract class CommonApplication extends MultiDexApplication {

    private List<Class<? extends CommonAppInit>> classInitList = new ArrayList();

    private List<CommonAppInit> appInitList = new ArrayList();


    @Override
    public void onCreate() {
        super.onCreate();
        appInit();
        initCreate();
    }


    protected abstract void appInit();

    protected void registerApplication(Class<? extends CommonAppInit> classInit) {
        classInitList.add(classInit);
    }


    private void initCreate() {
        for (Class<? extends CommonAppInit> classInit : classInitList) {
            try {
                CommonAppInit commonAppInit = classInit.newInstance();
                appInitList.add(commonAppInit);
                commonAppInit.onCreate();
                commonAppInit.setMApplication(this);
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (CommonAppInit commonAppInit : appInitList) {
            commonAppInit.onTerminate();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        for (CommonAppInit commonAppInit : appInitList) {
            commonAppInit.onLowMemory();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        for (CommonAppInit commonAppInit : appInitList) {
            commonAppInit.configurationChanged(newConfig);
        }
    }

}
