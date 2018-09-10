package com.police.assessment.policeassessment.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.base.activity.BaseActvity;
import com.police.assessment.policeassessment.bean.QuestionBean;
import com.police.assessment.policeassessment.fragment.AnswerFragment;

import org.wjh.androidlib.viewpager.PagerFragmentDynamicsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DayAnswerActivity extends BaseActvity {


    @BindView(R.id.vp)
    ViewPager vp;
    private PagerFragmentDynamicsAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_day_answer;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);

        adapter = new PagerFragmentDynamicsAdapter(getSupportFragmentManager(), getFragment());

        vp.setAdapter(adapter);
    }


    private List<Fragment> getFragment() {
        List<Fragment> fragments = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            QuestionBean bean = new QuestionBean();
            bean.setTitle("我是题目" + i);
            bean.setType(i % 2);

            List<String> list = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                list.add("我是选项" + j);
            }

            bean.setOptions(list);

            fragments.add(AnswerFragment.newInstance(bean));
        }

        return fragments;
    }

}
