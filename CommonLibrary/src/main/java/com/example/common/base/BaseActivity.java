package com.example.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseActivity extends AbstractActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(setLayout());
        initView();
        requsetData();
    }

    /**
     * 绑定布局
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 请求数据
     */

    protected abstract void requsetData();


    /**
     * 切换fragment
     * @param fragment 要显示的fragment
     * @param layoutId layout布局id
     */
    protected void switchFragmentRelace(Fragment fragment , int layoutId){
          if (fragment == null)return;
          checkFragmentStatus(fragment);
          FragmentManager fragmentManager =  getSupportFragmentManager();
          FragmentTransaction transaction = fragmentManager.beginTransaction();
          transaction.replace(layoutId , fragment , fragment.getClass().getSimpleName());
          transaction.commit();
    }

    /**
     * 切换fragment
     * @param fragment 要显示的fragment
     * @param layoutId layout布局id
     */
    protected void switchFragmentShow(Fragment fragment , int layoutId){
          if (fragment == null)return;
          checkFragmentStatus(fragment);
          FragmentManager fragmentManager =  getSupportFragmentManager();
          FragmentTransaction transaction = fragmentManager.beginTransaction();
          transaction.add(layoutId , fragment , fragment.getClass().getSimpleName()).show(fragment);
          transaction.commit();
    }

    protected void releaseFragment(Fragment fragment){
        if (fragment == null)return;
        checkFragmentStatus(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
    }

    protected void checkFragmentStatus(Fragment fragment){
        Fragment tempFragment = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        if (tempFragment != null){
            fragment = null;
            fragment = tempFragment;
        }
    }


}
