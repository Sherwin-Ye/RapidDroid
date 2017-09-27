package com.sherwin.radroid.base.framework.app;

import android.app.Application;

import com.sherwin.radroid.base.framework.util.LogUtil;


/**
 * @author Sherwin.Ye
 * @data 2015-11-26 上午9:28:44
 * @desc GlobalInfo.java
 */
public class GlobalApplication extends Application {

    private static final String TAG = "GlobalApplication";

    private static GlobalApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // 顺序不能换
        try {
            GlobalConfig.init(isDebug());
        } catch (Exception e) {
            LogUtil.e(TAG, "GlobalConfig init error : " + e);
        }
        try {
            GlobalInfo.init(this);
        } catch (Exception e) {
            LogUtil.e(TAG, "GlobalInfo init error : " + e);
        }
        // 初始化缓存工具
        GlobalMemoryCache.init();

    }

    /**
     * 配置debug模式
     * @return default false
     */
    protected boolean isDebug(){
        return false;
    }

    public static GlobalApplication getInstance() {
        return instance;
    }
}
