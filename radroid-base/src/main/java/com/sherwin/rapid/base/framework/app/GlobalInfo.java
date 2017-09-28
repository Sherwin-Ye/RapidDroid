package com.sherwin.rapid.base.framework.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.sherwin.rapid.base.framework.util.PackageUtil;


/**
 * @author Sherwin.Ye
 * @data 2016年9月14日 15:19:54
 * @desc GlobalInfo.java
 */
public class GlobalInfo {

    private static final String TAG = "GlobalInfo";

    private static Context mContext;
    private static Handler mHandlerMain = null;
    private static int mVerCode;
    private static String mVerName;
    private static String mChannelCode;
    private static String mPackageName;

    public static void init(Application application) {
        mContext = application;
        mHandlerMain = new Handler();
        mVerCode = PackageUtil.getVersionCode(mContext);
        mVerName = PackageUtil.getVersionName(mContext);
        mChannelCode = PackageUtil.getInfo(mContext).getChannelCode();
        mPackageName = PackageUtil.getInfo(mContext).getPackageName();
    }

    public static Context getContext() {
        return mContext;
    }

    public static Handler getHandlerMain() {
        return mHandlerMain;
    }

    public static int getVerCode() {
        return mVerCode;
    }

    public static String getVerName() {
        return mVerName;
    }

    public static String getChannelCode() {
        return mChannelCode;
    }

    public static String getPackageName() {
        return mPackageName;
    }


}
