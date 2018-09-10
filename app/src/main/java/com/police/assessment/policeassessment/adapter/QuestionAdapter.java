package com.police.assessment.policeassessment.adapter;

import android.content.Context;

import com.police.assessment.policeassessment.R;

import org.wjh.androidlib.listadapter.LoadMoreSingleLayoutAdapter;
import org.wjh.androidlib.listadapter.RecyclerViewHolder;

public class QuestionAdapter extends LoadMoreSingleLayoutAdapter<String> {


    public QuestionAdapter(Context context) {
        super(context, R.layout.rv_question);
    }

    @Override
    public void bind(RecyclerViewHolder recyclerViewHolder, String s, int i) {

        recyclerViewHolder.getTextView(R.id.content).setText(s);
    }
}
