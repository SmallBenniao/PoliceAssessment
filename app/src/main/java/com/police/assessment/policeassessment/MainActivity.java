package com.police.assessment.policeassessment;

import com.police.assessment.policeassessment.base.activity.BaseActvity;
import com.police.assessment.policeassessment.fragment.AssessmentFragment;
import com.police.assessment.policeassessment.fragment.HomeFragment;
import com.police.assessment.policeassessment.fragment.MeFragment;
import com.police.assessment.policeassessment.fragment.StudyFragment;

import org.wjh.androidlib.bottomtab.BottomBarEntity;
import org.wjh.androidlib.bottomtab.BottomBarItem;
import org.wjh.androidlib.bottomtab.BottomTab;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActvity {

    @BindView(R.id.bottom_bar)
    BottomTab bottomBar;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        // 设置底部导航栏数据
        bottomBar.setTabDatas(initDatas());
    }


    private List<BottomBarEntity> initDatas() {

        List<BottomBarEntity> list = new ArrayList<>();

        list.add(new BottomBarEntity(HomeFragment.class,
                new BottomBarItem(this, R.mipmap.home_normal, R.mipmap.home_press, "主页")
        ));


        list.add(new BottomBarEntity(StudyFragment.class,
                new BottomBarItem(this, R.mipmap.study_normal, R.mipmap.study_press,
                        "学习")
        ));

        list.add(new BottomBarEntity(AssessmentFragment.class,
                new BottomBarItem(this, R.mipmap.assessment_normal, R.mipmap.assessment_press,
                        "考核")
        ));


        list.add(new BottomBarEntity(MeFragment.class,
                new BottomBarItem(this, R.mipmap.me_normal, R.mipmap.me_press,
                        "我的")
        ));

        return list;
    }
}
