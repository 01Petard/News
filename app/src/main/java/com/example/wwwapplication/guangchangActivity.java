//package com.example.wwwapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import com.google.gson.Gson;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class guangchangActivity extends AppCompatActivity {
//    private static final String TAG = "guangchangActivity";
//    private WebView mWebView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guangchang);
//
//        mWebView = findViewById(R.id.main_web_view);
//        //解决点击链接跳转浏览器问题
//        mWebView.setWebViewClient(new WebViewClient());
//        //js支持
//        WebSettings settings = mWebView.getSettings();
//        settings.setJavaScriptEnabled(true);
//        //允许访问assets目录
//        settings.setAllowFileAccess(true);
//        //设置WebView排版算法, 实现单列显示, 不允许横向移动
//        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        //assets文件路径
//        String path = "file:///android_asset/index.html";
//        //添加Json数据
//        addJson();
//        //加载Html页面
//        mWebView.loadUrl(path);
//    }
//
//    private void addJson() {
//        JsSupport jsSupport = new JsSupport(this);
//        List<FriendsZone> zones = new ArrayList<>();
//
//
//        zones.add(new FriendsZone("www", "images/icon.png", "【小清新风光的场景唯美插画图片】“期待万物复苏的春天，好像可以给自己一个理由，扔掉一切糟糕的情绪，拍一拍身上的尘土，继续笑着向前。”让他带你慢慢入梦！ ", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("xxx", "images/icon.png", "#情话# #壁纸# 经典爱情伤感文字唯美带字风景图片。我不愿让你一个人，一个人在人海浮沉。与我相拥，附着一句抱歉，近来的打扰。宁愿笑着流泪，也不要哭着说后悔。一段感情不管当初有多开心，分手时就有多难过，一组爱情伤感文字分享。", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("Tom", "images/icon.png", "【雪莉给烤鳗鱼配音再被批 回应：你们更可恶】20日， #崔雪莉#分享一段烤鳗鱼视频→-微博视频 视频中，烤盘中的鳗鱼头还在动，雪莉在一旁配音\"啊~救救我～\"不料却遭网友批评，称鳗鱼还活着，雪莉笑着配音的做法过于残忍。随后，雪莉发文回应：“你们别吃鳗鱼。”并评论道“你们更可恶！ ", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("Lily", "images/icon.png", "深海之蓝！！！！ ", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("Cindy", "images/icon.png", "当我觉得我倒霉了，我就会想：这是在挥洒我的霉运，挥洒之后，剩下的就全都是幸运了! ", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("www", "images/icon.png", "【小清新风光的场景唯美插画图片】“期待万物复苏的春天，好像可以给自己一个理由，扔掉一切糟糕的情绪，拍一拍身上的尘土，继续笑着向前。”让他带你慢慢入梦！ ", "drawable/t1.jpg"));
//        zones.add(new FriendsZone("www", "images/icon.png", "【小清新风光的场景唯美插画图片】“期待万物复苏的春天，好像可以给自己一个理由，扔掉一切糟糕的情绪，拍一拍身上的尘土，继续笑着向前。”让他带你慢慢入梦！ ", "drawable/t1.jpg"));
//
//        Gson gson = new Gson();
//        String json = gson.toJson(zones);
//        Log.d(TAG, "addJson: json => " + json);
//        jsSupport.setJson(json);
//        //添加js交互接口, 并指明js中对象的调用名称
//        mWebView.addJavascriptInterface(jsSupport, "weichat");
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (mWebView.canGoBack()) {
//            mWebView.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }
//}
//
