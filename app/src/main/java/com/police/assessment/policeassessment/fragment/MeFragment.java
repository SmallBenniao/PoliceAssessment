package com.police.assessment.policeassessment.fragment;


import android.view.View;
import android.widget.ImageView;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.base.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的模块
 */
public class MeFragment extends BaseFragment {


    @BindView(R.id.right_button)
    ImageView rightButton;
    Unbinder unbinder;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_me;
    }

    @Override
    public void init(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
        rightButton.setVisibility(View.VISIBLE);
    }


    @OnClick(R.id.right_button)
    public void onViewClicked() {
        showSuccessMsg("设置");
    }

}
