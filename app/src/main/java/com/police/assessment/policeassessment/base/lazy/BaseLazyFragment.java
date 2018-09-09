package com.police.assessment.policeassessment.base.lazy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wjh.androidlib.dialog.WaitDialog;
import org.wjh.androidlib.fragment.ViewPagerLazyFragment;
import org.wjh.androidlib.tsnackbar.Prompt;
import org.wjh.androidlib.tsnackbar.TSnackbar;

import java.io.File;

public abstract class BaseLazyFragment extends ViewPagerLazyFragment {

    protected WaitDialog loadingDialog;
    protected Object sign;
    protected static final int REQUEST_CODE_CHOOSE = 23;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadingDialog = new WaitDialog();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void jumpActivity(Class targetClass) {
        startActivity(new Intent(getActivity(), targetClass));
    }


    protected void jumpActivity(Class targetClass, String key, String value) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, String value1) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        startActivity(intent);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, boolean value1) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        startActivity(intent);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, String value1, String key2, String value2) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.putExtra(key2, value2);
        startActivity(intent);
    }

    protected void jumpActivity(Class targetClass, String key, String value, String key1, String value1, String key2, String value2, String key3, String value3) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        intent.putExtra(key2, value2);
        intent.putExtra(key3, value3);
        startActivity(intent);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass) {
        Intent intent = new Intent(getActivity(), targetClass);
        startActivityForResult(intent, requestCode);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass, String key, String value) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        startActivityForResult(intent, requestCode);
    }

    protected void jumpActivityForResult(int requestCode, Class targetClass, String key, String value, String key1, String value1) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
        intent.putExtra(key1, value1);
        startActivityForResult(intent, requestCode);
    }

    public void showSuccessMsg(String msg) {
        TSnackbar.make(mActivity, Prompt.SUCCESS, dip2px(48), msg).show();
    }

    public void showWaringMsg(String msg) {
        TSnackbar.make(mActivity, Prompt.WARNING, dip2px(48), msg).show();
    }

    public void showErrorMsg(String msg) {
        TSnackbar.make(mActivity, Prompt.ERROR, dip2px(48), msg).show();
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
}
