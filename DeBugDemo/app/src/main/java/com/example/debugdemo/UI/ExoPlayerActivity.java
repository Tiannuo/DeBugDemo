package com.example.debugdemo.UI;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.debugdemo.R;
import com.example.debugdemo.Wight.VideoSurfaceView;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;

/**
 * Created by Administrator on 2016/1/26 0026.
 */
public class ExoPlayerActivity extends AppCompatActivity implements ExoPlayer.Listener{
    private ExoPlayer player;
    private VideoSurfaceView videoSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exoplayer);
        initView();
        preparePlayer();
    }

    private void preparePlayer() {
        if (player==null){
            player=ExoPlayer.Factory.newInstance(2,1000,5000);
            Uri uri=Uri.parse("http://covertness.qiniudn.com/android_zaixianyingyinbofangqi_test_baseline.mp4");
            //player.prepare(new MediaCodecVideoTrackRenderer(ExoPlayerActivity.t));
        }








    }

    private void initView() {
        videoSurfaceView= (VideoSurfaceView) findViewById(R.id.surfaceView);
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

    }

    @Override
    public void onPlayWhenReadyCommitted() {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }
}
