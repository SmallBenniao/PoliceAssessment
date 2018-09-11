package com.police.assessment.policeassessment.fragment;


import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.adapter.RankingAdapter;
import com.police.assessment.policeassessment.base.fragment.BaseListMultiFragment;

import org.wjh.androidlib.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页模块
 */
public class HomeFragment extends BaseListMultiFragment {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.me_layout)
    LinearLayout meLayout;
    @BindView(R.id.me_layout2)
    LinearLayout meLayout2;
    @BindView(R.id.nv)
    NestedScrollView nv;

    private boolean isFirstLoad = true;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }


    @Override
    public void load() {

        if (isFirstLoad)
            super.load();
        else
            requestData(++currentPage);
    }

    @Override
    public void init(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initAdapter() {
        adapter = new RankingAdapter(mContext);
    }

    @Override
    public void initRecyclerAndSwipe() {
        defaultInitList(rv, null, new LinearLayoutManager(mContext));
    }

    @Override
    protected void initListener() {

        final int px = UiUtils.dip2px(mContext, 180);

        nv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Log.e("ddd",scrollY+"-");

                if (scrollY > px)
                    meLayout2.setVisibility(View.VISIBLE);
                else
                    meLayout2.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public void requestData(int page) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add("龙哥" + i);
        }

        adapter.addData(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
