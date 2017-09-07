package com.atguigu.mobileplayer2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.atguigu.mobileplayer2.R;
import com.atguigu.mobileplayer2.bean.SearchBean;
import com.atguigu.mobileplayer2.view.MyWebView;

import java.util.List;
public class WebActivity extends Activity {
    private MyWebView myWebView;
    private WebView webView;
    private List<SearchBean.ItemData> items;
    private int position;
    private SearchBean.ItemData itemData;
    private String detailUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        myWebView= (MyWebView) findViewById(R.id.my_webview);
        webView=myWebView.getWebView();
        getData();
        initData();

    }
    private void initData() {
        webView.loadUrl(detailUrl);
    }

    private void getData() {
        items = (List<SearchBean.ItemData>) getIntent().getSerializableExtra("searchList");
        position=getIntent().getIntExtra("position",0);
        itemData = items.get(position);
        detailUrl = itemData.getDetailUrl();
    }
}
