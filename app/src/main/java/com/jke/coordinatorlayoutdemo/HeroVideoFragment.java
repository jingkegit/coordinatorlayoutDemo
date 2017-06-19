package com.jke.coordinatorlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Describes tab2 视频 tab3 攻略
 * Created by 荆柯 on 2017/3/10.
 */

public class HeroVideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video,container,false);
        RecyclerView lv = (RecyclerView) view.findViewById(R.id.data_lv);
        lv.setLayoutManager(new LinearLayoutManager(getActivity()));
        VideoListAdapter adapter = new VideoListAdapter(getActivity());
        lv.setAdapter(adapter);
        return view;
    }
}
