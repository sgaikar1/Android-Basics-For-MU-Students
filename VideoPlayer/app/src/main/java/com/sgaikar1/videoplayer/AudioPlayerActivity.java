package com.sgaikar1.videoplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * Created by Santosh Gaikar on 27/12/17.
 */


public class AudioPlayerActivity extends AppCompatActivity{
    Button start,pause,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        String mediaPath=Environment.getExternalStorageDirectory().getPath()+"/Music/song.mp3";

        start=(Button)findViewById(R.id.btn_start);
        pause=(Button)findViewById(R.id.btn_pause);
        stop=(Button)findViewById(R.id.btn_stop);
        //creating media player
        final MediaPlayer mp=new MediaPlayer();
        try{
            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
            mp.setDataSource(mediaPath);
            mp.prepare();

        }catch(Exception e){e.printStackTrace();}

        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }
}