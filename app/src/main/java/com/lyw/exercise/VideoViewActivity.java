package com.lyw.exercise;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.video_view);
        videoView = (VideoView) findViewById(R.id.video);
        File file = new File(Environment.getExternalStorageDirectory(), "1479097532076.mp4");
        if (file.exists()) {
//            Uri uri = Uri.fromFile(file);
            Uri uri = Uri.parse("http://baobab.wdjcdn.com/1451897812703c.mp4");
            videoView.setVideoPath(uri.toString());
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
        }
    }
}
