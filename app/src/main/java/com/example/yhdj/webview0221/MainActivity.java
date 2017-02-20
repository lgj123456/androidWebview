package com.example.yhdj.webview0221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
                return true;
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100){
                    Toast.makeText(MainActivity.this, "网页加载完成！！！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "网页加载中······", Toast.LENGTH_SHORT).show();
                }

                super.onProgressChanged(view, newProgress);
            }
        });


        mWebView.loadUrl("http://www.baidu.com");
    }
}
