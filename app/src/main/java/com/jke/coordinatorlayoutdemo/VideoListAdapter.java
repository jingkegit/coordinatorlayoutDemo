package com.jke.coordinatorlayoutdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Describes
 * Created by 荆柯 on 2017/3/10.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {

    private Context mContext;

    public VideoListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_layout,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String url = "http://124.193.230.153/vhot2.qqvideo.tc.qq.com/e0332xoc6v2.mp4?vkey=115" +
                "DDC4AAE3DD487387016FCD9AB4F6B99650BD7A02DFB11" +
                "946B65446C4F5828F7D9972B4277E223E795E3A1AFF70338F39" +
                "1A2E6DD67A7C7362DE43F620F1E4FFF14187BEC5541DA3BDF9C5453C6A673E18B60DE0D008BBA";
        holder.player.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST,
                "王者荣耀诸葛亮五杀视频视频集锦");
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {
        private JCVideoPlayer15w player;

        public ViewHolder(View itemView) {
            super(itemView);
            player = (JCVideoPlayer15w) itemView.findViewById(R.id.player);
        }
    }
}
