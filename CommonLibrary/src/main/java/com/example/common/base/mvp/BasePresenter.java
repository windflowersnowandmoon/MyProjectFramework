package com.example.common.base.mvp;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/2
 * 描   述 :P层的基类
 */
public class BasePresenter<T extends IBaseView> {

    protected String TAG = BasePresenter.class.getSimpleName();

    /**
     * 弱引用管理V层对象
     */
    protected WeakReference<T> mViewRef;

    /**
     * 与V层进行绑定
     *
     * @param view V层对象
     */
    public void attchView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 与V层解绑
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
            System.gc();
        }
    }

    /**
     * 判断当前状态是否为绑定状态
     *
     * @return T
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 获取V层
     *
     * @return T
     */
    protected T getView() {
        return mViewRef.get();
    }

    protected <T> T create(Context context, Class<T> Class) {
        return null;
    }
}
