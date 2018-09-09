package com.police.assessment.policeassessment.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import org.wjh.androidlib.dialog.WaitDialog;
import org.wjh.androidlib.nohttp.NohttpUtils;
import org.wjh.androidlib.tsnackbar.Prompt;
import org.wjh.androidlib.tsnackbar.TSnackbar;

import java.io.File;


public abstract class BaseActvity extends AppCompatActivity {

    protected Object sign = new Object();
    protected WaitDialog loadingDialog;
    protected Activity mContext;

    protected static final int REQUEST_CODE_CHOOSE = 23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        mContext = this;

        // 代码设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        loadingDialog = new WaitDialog();

        init();

        load();
    }


    public abstract int getLayoutResId();

    public abstract void init();

    public void load() {

    }

    /**
     * Intent取值
     */
    public String getStringByIntent(String key) {

        String stringExtra = getIntent().getStringExtra(key);

        return TextUtils.isEmpty(stringExtra) ? "" : stringExtra;
    }

    /**
     * Intent取值
     */
    public Integer getIntegerByIntent(String key) {

        return getIntent().getIntExtra(key, -1);
    }

    /**
     * Intent取值
     */
    public Boolean getBooleanByIntent(String key) {

        return getIntent().getBooleanExtra(key, false);
    }

    protected Boolean isInputAll(TextView... args) {

        for (int i = 0; i < args.length; i++) {
            TextView arg = args[i];

            if (TextUtils.isEmpty(arg.getText().toString())) {
                return false;
            }

        }

        return true;

    }

    protected void jumpActivity(Class targetClass) {
        startActivity(new Intent(this, targetClass));
    }


    protected void jumpActivity(Class targetClass, String key, String value) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivityForResult(intent, requestCode);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass, String key, String value) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtra(key, value);
        startActivityForResult(intent, requestCode);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, String value1, String key2, String value2) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.putExtra(key2, value2);
        startActivity(intent);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, String value1) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        startActivity(intent);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass, String key, String value, String key1, String value1) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        startActivityForResult(intent, requestCode);
    }

    // 当页面关闭掉 结束网路请求
    @Override
    protected void onDestroy() {
        super.onDestroy();
        NohttpUtils.getInstance().cancelBySign(sign);
    }


    public void showSuccessMsg(String msg) {
        TSnackbar.make(mContext, Prompt.SUCCESS, dip2px(48), msg).show();
    }

    public void showWaringMsg(String msg) {
        TSnackbar.make(mContext, Prompt.WARNING, dip2px(48), msg).show();
    }

    public void showErrorMsg(String msg) {
        TSnackbar.make(mContext, Prompt.ERROR, dip2px(48), msg).show();
    }

    public int dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    // 存储路径
    protected String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/policeAssessment/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

    public void hintKeyBoard() {
        //拿到InputMethodManager
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //如果window上view获取焦点 && view不为空
        if (imm.isActive() && getCurrentFocus() != null) {
            //拿到view的token 不为空
            if (getCurrentFocus().getWindowToken() != null) {
                //表示软键盘窗口总是隐藏，除非开始时以SHOW_FORCED显示。
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 验证手机格式
     */
    protected boolean isMobileNO(String mobiles) {

        // 手机号段越来越多 第一位一直是1，位数11位
        String trim = mobiles.trim();

        if (TextUtils.isEmpty(trim)) {
            return false;
        } else {

            CharSequence charSequence = trim.subSequence(0, 1);

            int i = Integer.parseInt(charSequence.toString());

            if (i != 1) {

                return false;
            } else {

                int length = trim.length();

                if (length == 11) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
