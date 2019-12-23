package com.example.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        initView(view);
        return view;
    }

    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化view
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();

//    /**
//     * 请求数据
//     */
//
//    protected abstract void requsetData();


    /**
     * 切换fragment
     *
     * @param fragment 要显示的fragment
     * @param layoutId layout布局id
     */
    protected void switchFragmentRelace(Fragment fragment, int layoutId) {
        if (fragment == null) return;
        checkFragmentStatus(fragment);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(layoutId, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
    }

    /**
     * 切换fragment
     *
     * @param fragment 要显示的fragment
     * @param layoutId layout布局id
     */
    protected void switchFragmentShow(Fragment fragment, int layoutId) {
        if (fragment == null) return;
        checkFragmentStatus(fragment);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layoutId, fragment, fragment.getClass().getSimpleName()).show(fragment);
        transaction.commit();
    }

    protected void releaseFragment(Fragment fragment) {
        if (fragment == null) return;
        checkFragmentStatus(fragment);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    protected void checkFragmentStatus(Fragment fragment) {
        Fragment tempFragment = getChildFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        if (tempFragment != null) {
            fragment = null;
            fragment = tempFragment;
        }
    }

}
