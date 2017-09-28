package com.sherwin.rapid.base.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sherwin.Ye on 2016/11/7.13:38
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    private View layout;

    public T mDataBinding;

    /**
     * 页面初始化是否完成
     */
    private boolean isLoadFinish = false;

    public BaseFragment() {

    }

    /**
     * 设置资源
     *
     * @return
     */
    protected abstract int getContentLayout();

    /**
     * 初始化控件信息
     */
    protected abstract void initView();

    /**
     * 初始化监听
     */
    protected void initListener() {

    }

    /**
     * 初始化监听
     */
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isLoadFinish = false;
        if (layout == null) {
            mDataBinding = DataBindingUtil.inflate(inflater, getContentLayout(), null, false);
            layout = mDataBinding.getRoot();
            layout.setTag(mDataBinding);
        } else {
            mDataBinding = (T) layout.getTag();
        }
        return layout;
    }

    @Override
    public void onStart() {//相当于reStart
        super.onStart();
        if (!isLoadFinish){
            initView();
            initListener();
            initData();
            isLoadFinish = true;
        }
    }

    /**
     * 页面初始化是否完成
     * @return
     */
    public boolean isLoadFinish() {
        return isLoadFinish;
    }

    /**
     * 快速启动一个activity
     *
     * @param clazz
     */
    protected void startActivity(Class clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * 关闭当前activity
     */
    protected void finish(){
        getActivity().finish();
    }

}
