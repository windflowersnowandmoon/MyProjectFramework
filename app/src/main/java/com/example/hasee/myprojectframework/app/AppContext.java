package com.example.hasee.myprojectframework.app;

import android.content.Context;

import com.example.common.base.AbstractAppLication;

import androidx.multidex.MultiDex;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/3
 * 描   述 :个人信息
 */
public class AppContext extends AbstractAppLication {
    public static AppContext appContext;

    public static AppContext getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
