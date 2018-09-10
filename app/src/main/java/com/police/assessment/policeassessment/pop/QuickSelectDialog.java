package com.police.assessment.policeassessment.pop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.police.assessment.policeassessment.R;
import com.police.assessment.policeassessment.adapter.QuickSelectAdapter;

import org.wjh.androidlib.listadapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class QuickSelectDialog {

    private PopupWindow mPopWindow;

    private int totle;

    public QuickSelectDialog(Context context, int totle, final QuickSelectListener listener) {
        this.totle = totle;

        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_quick_select, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        RecyclerView rv = (RecyclerView) contentView.findViewById(R.id.rv);

        rv.setLayoutManager(new GridLayoutManager(context, 6));

        List<String> list = new ArrayList<>();

        for (int i = 0; i < totle; i++) {
            list.add(i + 1 + "");
        }

        QuickSelectAdapter adapter = new QuickSelectAdapter(context);
        rv.setAdapter(adapter);
        adapter.addData(list);

        adapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onClick(String s, int i, View view) {
                listener.selcet(i);
                mPopWindow.dismiss();
            }
        });

    }


    public void show(View rootview) {

        mPopWindow.showAsDropDown(rootview);
    }

    public void dissmiss() {

        mPopWindow.dismiss();
    }


    public interface QuickSelectListener {
        void selcet(int index);
    }

}
