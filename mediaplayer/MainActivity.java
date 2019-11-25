package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    SeekBar s1;
    Handler seekhandler = new Handler();
    boolean isrun = true;
    int currentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.seekBar);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentpos=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(currentpos);
                player.seekTo(currentpos);
            }
        });
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            if (isrun) {
                updation();
            }
        }
    };

    void updation() {
        s1.setProgress(player.getCurrentPosition());
        seekhandler.postDelayed(run, 1000);
    }

    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.linkin);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        player.start();

        isrun = true;
        updation();

        s1.setMax(player.getDuration());
    }


    public void pause(View v) {
        if (player != null) {
            player.pause();
            Toast.makeText(this, "Song paused", Toast.LENGTH_LONG).show();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    public void stopPlayer() {
        if (player != null) {
            isrun = false;
            player.release();
            player = null;
            Toast.makeText(this, "Song stopped", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
