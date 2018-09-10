package com.police.assessment.policeassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.adapter.QuestionAdapter;
import com.police.assessment.policeassessment.base.fragment.BaseListFragment;
import com.police.assessment.policeassessment.bean.QuestionBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnswerFragment extends BaseListFragment {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.rv)
    RecyclerView rv;
    private QuestionBean question;

    Unbinder unbinder;

    public static AnswerFragment newInstance(QuestionBean bean) {

        Bundle args = new Bundle();

        args.putSerializable("question", bean);

        AnswerFragment fragment = new AnswerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_answer;
    }

    @Override
    public void init(View rootView) {
        unbinder = ButterKnife.bind(this, rootView);

        question = (QuestionBean) getArguments().getSerializable("question");

        title.setText(question.getTitle());
    }


    @Override
    protected void initAdapter() {
        adapter = new QuestionAdapter(mContext);
    }

    @Override
    public void initRecyclerAndSwipe() {
        defaultInitList(rv, null, new LinearLayoutManager(mContext));
        successNeedTodo(null);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void requestData(int page) {
        adapter.addData(question.getOptions());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
