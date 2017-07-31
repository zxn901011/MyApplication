package com.atguigu.mobileplayer2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by zxn on 2017-07-31.
 */

public class MyWebView extends RelativeLayout {
    public MyWebView(Context context) {
        this(context,null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        this(context,null,0);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
