package com.police.assessment.policeassessment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.police.assessment.policeassessment.R;


public class SelectItem extends RelativeLayout {

    private String title = "";
    private String content = "";

    private TextView contentTv;

    private OnClickListener onClickListener;

    public SelectItem(Context context) {
        this(context, null);
    }

    public SelectItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        getAttrs(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.select_item, this, true);


        ((TextView) this.findViewById(R.id.title)).setText(title);

        contentTv = ((TextView) this.findViewById(R.id.content));
        contentTv.setText(content);

        this.findViewById(R.id.layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null)
                    onClickListener.clickItem(SelectItem.this);
            }
        });


        contentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null)
                    onClickListener.clickSelectItem(SelectItem.this);
            }
        });
    }


    /**
     * 得到属性值
     *
     * @param context
     * @param attrs
     */
    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SelectItemStyle);
        title = ta.getString(R.styleable.SelectItemStyle_itemTitle);
        content = ta.getString(R.styleable.SelectItemStyle_itemContent);
        ta.recycle();
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void clickItem(View v);

        void clickSelectItem(View v);
    }
}
