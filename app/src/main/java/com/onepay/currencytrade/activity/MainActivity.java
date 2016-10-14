package com.onepay.currencytrade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.onepay.currencytrade.R;
import com.onepay.currencytrade.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private WebView webViewDescription;


    WebSettings webSettings;

    private String url = "http://test.palermo1.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    /**
     * 方法说明：初始化UI
     *
     * @author 张春明
     * 返回类型:@void
     * 创建时间:2016年1月20日下午2:59:32
     */
    private void findViews() {
//        gson = new Gson();
//        progressbar = (ProgressWheel)   (R.id.progressbar);
        // swipe_ly = (SwipeRefreshLayout) findViewById(R.id.swipe_ly);
        // swipe_ly.setOnRefreshListener(this);
        // swipe_ly.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_green_light, android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
        webViewDescription = (WebView) findViewById(R.id.webViewDescription);
        webViewDescription.setBackgroundColor(0); // 设置背景色
        //webViewDescription.getBackground().setAlpha(0); // 设置填充透明度 范围：0-255
        webViewDescription.setBackgroundResource(R.mipmap.login_screen);
        //mSpinKitView = (SpinKitView) findViewById(R.id.spin_kit);
        //WebView硬件加速导致页面渲染闪烁
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            webViewDescription.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        } else {
//
//        }
        //Webview 不向系统浏览器跳转
        webViewDescription.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;

            }
        });
//        iv_foreground = (ImageView) findViewById(R.id.iv_foreground);
        //webSettings.setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
        webSettings = webViewDescription.getSettings();
//        //设置js可以直接打开窗口，如window.open()，默认为false
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        // 添加缩放
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setSupportZoom(true);
//        // 自适应屏幕
        webSettings.setUseWideViewPort(true);// 设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        //webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //webSettings.setDomStorageEnabled(true);
        setWebView(url);
    }

    /**
     * 方法说明：设置webview
     *
     * @author 张春明
     * 返回类型:@void
     * 创建时间:2015年9月7日上午11:32:30
     */
    private void setWebView(String desc_path) {

//        webViewDescription.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return false;
//            }
//        });

        webViewDescription.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress >= 100) {
//                    isNoFirst = false;
                    // mSpinKitView.setVisibility(View.GONE);
                } else {
                    // mSpinKitView.setVisibility(View.VISIBLE);
//                    if (!isNoFirst) {
//                        progressbar.setVisibility(View.VISIBLE);
//                    }
                }
            }
        });
        webViewDescription.loadUrl(desc_path);
    }


    // 设置回退
    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webViewDescription.canGoBack()) {
            webViewDescription.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }else{
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (webViewDescription != null) {
            try {
                webViewDescription.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
