package com.sherwin.radroid.base.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

/**
 * @author Sherwin.Ye
 * @data 2016年9月13日 17:53:01
 * @desc BaseActivity.java
 */
public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {
    public T mDataBinding;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        beforeLoadContent();
        mDataBinding = DataBindingUtil.setContentView(this, getContentLayout());
        initView();
        initListener();
        initData();
    }

    /**
     * 加载布局前执行
     */
    protected void beforeLoadContent(){

    }

    /**
     * 设置资源
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


//    protected void showWaitingDialog(String msg) {
//        if (mWaitingDialog == null) {
//            mWaitingDialog = LoadingDialog.createDialog(getActivity());
//        }
//        mWaitingDialog.setMessage(msg);
//        if (!mWaitingDialog.isShowing())mWaitingDialog.show();
//    }
//
//    protected void dismissWaitingDialog() {
//        if (mWaitingDialog != null) {
//            mWaitingDialog.dismiss();
//        }
//    }



}
