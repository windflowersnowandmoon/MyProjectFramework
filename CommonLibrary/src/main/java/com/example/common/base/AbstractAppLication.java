package com.example.common.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.example.common.utils.LogUtils;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/3
 * 描   述 :个人信息
 */
public abstract class AbstractAppLication extends Application implements Application.ActivityLifecycleCallbacks {


    @Override
    public void onCreate() {
        super.onCreate();
        initLibraries();
    }

    /**
     * 初始化项目共有的库，不是这个项目独有的
     */
    private void initLibraries(){
//       if (){
        LogUtils.getBuilder();
//       }
    }

    /**
     * onTerminate()会在Android的模拟器上触发回调。
     * 不会在Android真实的机器设备上触发
     * ————————————————
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 注册对APP内所有Activity的生命周期监听
     * @param callback
     */
    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    /**
     * 注销对APP内所有Activity的生命周期监听
     * @param callback
     */
    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }


    @Override
    public void onActivityStarted(Activity activity) {

    }


    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }


    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
