package com.police.assessment.policeassessment.app;

import android.app.Application;

import com.yanzhenjie.nohttp.NoHttp;

import org.wjh.androidlib.utils.ToastUtils;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // NoHttp全局初始化
        NoHttp.initialize(this);
        // ToastUtils全局初始化
        ToastUtils.init(this);
    }
}
