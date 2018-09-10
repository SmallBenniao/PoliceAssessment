package com.police.assessment.policeassessment.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.base.activity.BaseActvity;
import com.police.assessment.policeassessment.bean.QuestionBean;
import com.police.assessment.policeassessment.fragment.AnswerFragment;
import com.police.assessment.policeassessment.pop.QuickSelectDialog;

import org.wjh.androidlib.viewpager.PagerFragmentDynamicsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DayAnswerActivity extends BaseActvity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.quick_select)
    TextView quickSelect;
    @BindView(R.id.toolbar)
    RelativeLayout toolbar;

    private PagerFragmentDynamicsAdapter adapter;
    private List<Fragment> fragment;
    private QuickSelectDialog dialog;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_day_answer;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);

        fragment = getFragment();
        adapter = new PagerFragmentDynamicsAdapter(getSupportFragmentManager(), fragment);
        vp.setAdapter(adapter);
        quickSelect.setText("1/" + fragment.size());

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                quickSelect.setText(i + 1 + "/" + fragment.size());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        dialog = new QuickSelectDialog(mContext, fragment.size(), new QuickSelectDialog.QuickSelectListener() {
            @Override
            public void selcet(int index) {
                vp.setCurrentItem(index);
            }
        });
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


    @OnClick({R.id.back, R.id.quick_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.quick_select:
                dialog.show(toolbar);
                break;
        }
    }

}
