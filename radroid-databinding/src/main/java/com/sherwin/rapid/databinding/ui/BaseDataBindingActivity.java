package com.sherwin.rapid.databinding.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;

import com.sherwin.rapid.base.ui.BaseActivity;

/**
 * @author Sherwin.Ye
 * @data 2016年9月13日 17:53:01
 * @desc 实现Databinding 的 Activity
 */
public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {
    public T mDataBinding;

    @Override
    protected void setContentLyout() {
        mDataBinding = DataBindingUtil.setContentView(this, getContentLayout());
    }


}
