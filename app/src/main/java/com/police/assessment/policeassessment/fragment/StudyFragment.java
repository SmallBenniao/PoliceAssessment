package com.police.assessment.policeassessment.fragment;


import android.view.View;
import android.widget.ImageView;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.base.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 学习模块
 */
public class StudyFragment extends BaseFragment {


    @BindView(R.id.right_button)
    ImageView rightButton;
    Unbinder unbinder;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_study;
    }

    @Override
    public void init(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
