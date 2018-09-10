package com.police.assessment.policeassessment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.police.assessment.policeassessment.R;

import org.wjh.androidlib.listadapter.LoadMoreMultiLayoutAdapter;
import org.wjh.androidlib.listadapter.RecyclerViewHolder;

public class RankingAdapter extends LoadMoreMultiLayoutAdapter<String> {


    public RankingAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCustomItemViewType(int i) {

        if (i > 3)
            return 3;
        else
            return i;
    }

    @Override
    public RecyclerViewHolder onCreateCustomViewHolder(ViewGroup viewGroup, int type) {
        if (type == 0) {
            // 冠军
            View inflate = getAttachInflater().inflate(R.layout.rv_rankings_win, viewGroup, false);
            return new ViewHolder0(inflate);
        } else if (type == 1) {
            // 亚军
            View inflate = getAttachInflater().inflate(R.layout.rv_rankings_runner_up, viewGroup, false);
            return new ViewHolder1(inflate);
        } else if (type == 2) {
            // 季军
            View inflate = getAttachInflater().inflate(R.layout.rv_rankings_third_place, viewGroup, false);
            return new ViewHolder2(inflate);
        } else {
            // 其他
            View inflate = getAttachInflater().inflate(R.layout.rv_rankings_other, viewGroup, false);
            return new ViewHolder3(inflate);
        }
    }

    @Override
    public void onBindCustomViewHolder(RecyclerViewHolder recyclerViewHolder, String s, int i) {

        if (recyclerViewHolder instanceof ViewHolder0) {
            ((ViewHolder0) recyclerViewHolder).getTextView(R.id.name).setText(s);
        } else if (recyclerViewHolder instanceof ViewHolder1) {
            ((ViewHolder1) recyclerViewHolder).getTextView(R.id.name).setText(s);
        } else if (recyclerViewHolder instanceof ViewHolder2) {
            ((ViewHolder2) recyclerViewHolder).getTextView(R.id.name).setText(s);
        } else if (recyclerViewHolder instanceof ViewHolder3) {
            ((ViewHolder3) recyclerViewHolder).getTextView(R.id.name).setText(s);
        }
    }


    static class ViewHolder0 extends RecyclerViewHolder {

        public ViewHolder0(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolder1 extends RecyclerViewHolder {

        public ViewHolder1(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolder2 extends RecyclerViewHolder {

        public ViewHolder2(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolder3 extends RecyclerViewHolder {

        public ViewHolder3(View itemView) {
            super(itemView);
        }
    }
}
