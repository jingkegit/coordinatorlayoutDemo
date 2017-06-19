package com.jke.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Describes tab1 首页
 * Created by 荆柯 on 2017/3/10.
 */

public class HeroDesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_des,container,false);
        WebView webView = (WebView) view.findViewById(R.id.web_view);
        webView.loadUrl("http://news.17173.com/z/pvp/content/03192017/142316675.shtml");
        return view;
    }
}
