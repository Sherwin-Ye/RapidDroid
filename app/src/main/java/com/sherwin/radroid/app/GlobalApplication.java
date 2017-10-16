package com.sherwin.radroid.app;

import android.app.Application;

import com.sherwin.radroid.BuildConfig;
import com.sherwin.rapid.base.core.RapidDroid;

/**
 * @author Sherwin.Ye 674718661@qq.com
 * @date 2017/10/11.10:57
 * @desc
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RapidDroid.init(this, BuildConfig.DEBUG);
    }
}
