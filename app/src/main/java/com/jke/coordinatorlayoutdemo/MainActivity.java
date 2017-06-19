package com.jke.coordinatorlayoutdemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView toolBar_title;
    private ImageView back_img,share_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar_layout);
        tabLayout  = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        toolBar_title = (TextView) findViewById(R.id.toolbar_title);
        back_img = (ImageView) findViewById(R.id.toolbar_back);
        back_img.setOnClickListener(this);
        share_img = (ImageView) findViewById(R.id.toolbar_share);
        share_img.setOnClickListener(this);
        // AppBarLayout 滑动距离监听 使ToolBar背景色渐变
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("TAG","=====verticalOffset==="+verticalOffset);
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusHeight = rect.top;
                int endOffset  = appBarLayout.getHeight()-toolbar.getHeight()-tabLayout.getHeight()- statusHeight;
                Log.e("TAG","=====height==="+endOffset);
                int startOffset = 0;
                int offset = Math.abs(verticalOffset);
                if (offset <= startOffset) {  //alpha为0
                    toolbar.getBackground().setAlpha(0);
                    toolBar_title.setVisibility(View.GONE);
                    Log.e("TAG","=====setAlpha===0");
                } else if (offset > startOffset && offset < endOffset) { //alpha为0到255
                    float precent = (float) (offset - startOffset) / endOffset;
                    int alpha = Math.round(precent * 255);
                    toolbar.getBackground().setAlpha(alpha);
                    toolBar_title.setVisibility(View.GONE);
                    if(alpha<=126){
                        back_img.setImageResource(R.drawable.return_white);
                        share_img.setImageResource(R.drawable.share_white);
                    }else{
                        back_img.setImageResource(R.drawable.return_black);
                        share_img.setImageResource(R.drawable.share_black);
                    }
                    Log.e("TAG","=====setAlpha===precent"+alpha);
                } else if (offset >= endOffset) {  //alpha为255
                    toolbar.getBackground().setAlpha(255);
                    toolBar_title.setVisibility(View.VISIBLE);
                    back_img.setImageResource(R.drawable.return_black);
                    share_img.setImageResource(R.drawable.share_black);
                    Log.e("TAG","=====setAlpha===255");
                }
            }
        });
        // ViewPager 与 TabLayout 关联
        List<Fragment> fragments = new ArrayList<>();
        HeroDesFragment desFragment = new HeroDesFragment();
        HeroVideoFragment videoFragment = new HeroVideoFragment();
        HeroVideoFragment strategyFragment = new HeroVideoFragment();
        fragments.add(desFragment);fragments.add(videoFragment);fragments.add(strategyFragment);
        HeroDetailPagerAdapter adapter = new HeroDetailPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toolbar_back:// 返回
                finish();
                break;
            case R.id.toolbar_share:// 分享
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer15w.releaseAllVideos();
    }
}
