package com.sherwin.rapid.base.view;

/**
 * @author Sherwin.Ye 674718661@qq.com
 * @date 2017/9/28.10:00
 * @desc
 */
public interface IBaseView {
    /**
     * 加载布局前执行
     */
    void beforeLoadContent();

    /**
     * 设置资源
     * @return
     */
    int getContentLayout();

    /**
     * 初始化控件信息
     */
    void initView();

    /**
     * 初始化监听
     */
    void initListener();
    /**
     * 初始化监听
     */
    void initData();
}
