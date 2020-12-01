package com.lgw.android.common.customglide;

import android.content.Context;

/**
 * Created by lgw on 2020/11/27
 */
class CustomGlide {

    public static CustomRequestManager with(Context context) {
        return CustomRequestManager.getInstance().get(context);
    }


}
