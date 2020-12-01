package com.lgw.android.common.customglide;

import android.content.Context;

/**
 * Created by lgw on 2020/11/27
 */
class CustomRequestManager {
    private  Context context;
    private static CustomRequestManager customRequestManager;

    private CustomRequestManager() {
    }

    public static CustomRequestManager getInstance() {
        if (customRequestManager == null) {
            synchronized (CustomRequestManager.class) {
                if (customRequestManager == null) {
                    customRequestManager = new CustomRequestManager();
                }
            }
        }
        return customRequestManager;
    }


    public CustomRequestManager get(Context context) {
        this.context=context;
        return this;
    }
}
