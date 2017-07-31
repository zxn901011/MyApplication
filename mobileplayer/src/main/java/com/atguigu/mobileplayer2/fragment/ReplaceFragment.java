package com.atguigu.mobileplayer2.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.mobileplayer2.base.BasePager;

/**
 * 作者：zxn
 * 作用：独立成一个类，防止出错
 */
public class ReplaceFragment extends Fragment {

    private BasePager curPager;

    public ReplaceFragment(){
    }
    private ReplaceFragment(BasePager pager) {
        this.curPager=pager;
    }

    public static ReplaceFragment newInstance(BasePager pager) {
        ReplaceFragment fragment = new ReplaceFragment(pager);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return curPager.rootView;
    }
}

