package com.police.assessment.policeassessment.fragment;


import android.view.View;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.activity.DayAnswerActivity;
import com.police.assessment.policeassessment.base.fragment.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 考核模块
 */
public class AssessmentFragment extends BaseFragment {


    Unbinder unbinder;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_assessment;
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

    @OnClick({R.id.day, R.id.month, R.id.record, R.id.integral})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.day:
                jumpActivity(DayAnswerActivity.class);
                break;
            case R.id.month:
                break;
            case R.id.record:
                break;
            case R.id.integral:
                break;
        }
    }
}
