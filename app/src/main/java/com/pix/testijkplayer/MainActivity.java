package com.pix.testijkplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.pix.testijkplayer.common.PlayerManager;

public class MainActivity extends Activity implements PlayerManager.PlayerStateListener{
    private String url1 = "rtmp://203.207.99.19:1935/live/CCTV5";
    private String url2 = "http://zv.3gv.ifeng.com/live/zhongwen800k.m3u8";
    private String url3 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
    private String url4 = "http://42.96.249.166/live/24035.m3u8";
    private String jufanUrl = "http://ksdownhdl.jufan.tv/live/500488148.flv";
    private PlayerManager player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlayer();
    }

    private void initPlayer() {
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {
    }
}
