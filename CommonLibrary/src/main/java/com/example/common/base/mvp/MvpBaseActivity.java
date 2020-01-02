package com.example.common.base.mvp;

import android.os.Bundle;

import com.example.common.base.BaseActivity;

import androidx.annotation.Nullable;

/**
 * $
 * 作   者 :彭付林
 * 邮   箱 :pengfl@kingchannels.com
 * 日   期 :2020/1/2
 * 描   述 :个人信息
 */
public abstract class MvpBaseActivity<V extends IBaseView, P extends BasePresenter<V>> extends BaseActivity implements IBaseView {

    protected P mPresenter;

    /**
     * ((V)this)报警告，Unchecked cast 'MvpBaseActivity' to 'V'。 这个时候需要去除代码警告。
     * 在此方法上面或者那个强制类型转换的上面加上如下一句话。@SuppressWarnings(“unchecked”)
     *
     * @param savedInstanceState Bundle
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attchView((V) this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter.isViewAttached()){
            mPresenter.detachView();
        }
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onNetError(String netMsg) {

    }

    protected abstract P createPresenter();
}
