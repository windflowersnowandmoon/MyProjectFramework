package com.example.common.base.mvp;

import android.os.Bundle;

import com.example.common.base.BaseFragment;

import androidx.annotation.Nullable;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/2
 * 描   述 :个人信息
 */
public abstract class MvpBaseFragment<V extends IBaseView, P extends BasePresenter<V>> extends BaseFragment implements IBaseView {

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attchView((V) this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter.isViewAttached()) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onNetError(String netMsg) {

    }

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();


}
