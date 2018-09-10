package com.police.assessment.policeassessment.adapter;

import android.content.Context;

import com.police.assessment.policeassessment.R;

import org.wjh.androidlib.listadapter.RecyclerViewHolder;
import org.wjh.androidlib.listadapter.SimpleSingleLayoutAdapter;

public class QuickSelectAdapter extends SimpleSingleLayoutAdapter<String> {


    public QuickSelectAdapter(Context context) {
        super(context, R.layout.rv_quick_select);
    }

    @Override
    public void bind(RecyclerViewHolder recyclerViewHolder, String s, int i) {
        recyclerViewHolder.getTextView(R.id.tv).setText(s);
    }


}
