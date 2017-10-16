package com.sherwin.radroid;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.sherwin.radroid.databinding.ActivityMainBinding;
import com.sherwin.rapid.base.ui.annotation.ContentView;
import com.sherwin.rapid.databinding.ui.BaseDataBindingActivity;

@ContentView(layout = R.layout.activity_main)
public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding> {
    @Override
    public void initView(Bundle savedInstanceState) {
    }
}
