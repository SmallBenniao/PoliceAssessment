package com.police.assessment.policeassessment.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wjh.androidlib.dialog.WaitDialog;
import org.wjh.androidlib.nohttp.NohttpUtils;
import org.wjh.androidlib.tsnackbar.Prompt;
import org.wjh.androidlib.tsnackbar.TSnackbar;


public abstract class BaseFragment extends Fragment {

    protected Object sign = new Object();
    protected WaitDialog loadingDialog;

    protected Activity mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutResId(), container, false);
        loadingDialog = new WaitDialog();
        init(inflate);
        load();
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        NohttpUtils.getInstance().cancelBySign(sign);
    }

    public abstract int getLayoutResId();

    public abstract void init(View rootView);

    public void load() {

    }

    protected void jumpActivity(Class targetClass) {
        startActivity(new Intent(getActivity(), targetClass));
    }


    protected void jumpActivity(Class targetClass, String key, String value) {
        Intent intent = new Intent(getActivity(), targetClass);
        intent.putExtra(key, value);
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

}
