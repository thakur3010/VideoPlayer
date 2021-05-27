package com.example.myvideoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class player extends AppCompatActivity {



    VideoView videoView;
    TextView textView;
    SeekBar seekBar;
    ArrayList<File> arrayList;
    int position;
    Thread updateSeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
//        textView = findViewById(R.id.textView);
        videoView = findViewById(R.id.videoView);
//        seekBar = findViewById(R.id.seekBar);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        arrayList = (ArrayList) bundle.getParcelableArrayList("videolist");
//        textView.setText(intent.getStringExtra("videoName"));
        position = intent.getIntExtra("position",0);
        Uri uri = Uri.parse(arrayList.get(position).toString());
        videoView.setVideoURI(uri);
        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        videoView.start();
//        seekBar.setMax(videoView.getDuration());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                videoView.seekTo(seekBar.getProgress());
//            }
//        });
//        updateSeek = new Thread(){
//            @Override
//            public void run() {
//                int currentPosition = 0;
//                try {
//                    while(currentPosition < videoView.getDuration()){
//                        currentPosition = videoView.getCurrentPosition();
//                        seekBar.setProgress(currentPosition);
//                        sleep(800);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        updateSeek.start();
    }
}