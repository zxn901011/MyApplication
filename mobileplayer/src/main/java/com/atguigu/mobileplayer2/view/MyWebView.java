package com.atguigu.mobileplayer2.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.atguigu.mobileplayer2.R;

/**
 * Created by zxn on 2017-07-31.
 */
/**
 * 自定义WebView
 * @author LangK
 *
 */
public class MyWebView extends RelativeLayout{
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 浏览器
     */
    private WebView webView;
    /**
     * 加载进度
     */
    private ProgressBar progressBar;

    public MyWebView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }
    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }
    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initView();
    }
    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_web, this);
        webView = (WebView) view.findViewById(R.id.view_webView);
        progressBar = (ProgressBar) view.findViewById(R.id.view_webview_progress);
        initWebViewSet();
    }


    /**
     * 初始化WebView设置
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViewSet() {
        // 设置编码
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setTextZoom(70);
        // 设置背景颜色 透明
        webView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        // 设置缓存模式
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // //添加Javascript调用java对象
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        // 扩大比例的缩放设置此属性，可任意比例缩放。
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBlockNetworkImage(false);
        // 不启用硬件加速
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        // 自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

        // 重新WebView加载URL的方法
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(mContext, "网络错误", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });
    }

    /**
     * 获取WebView
     * @return
     */
    public WebView getWebView(){
        return webView;
    }
}
