package com.example.eongaku;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer [] player = new MediaPlayer[4];
    TextView result;
    String[] classes = {"Fear", "Happy", "Neutral", "Sad"};
    int emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        result = findViewById(R.id.resutlView);

        player[0] = MediaPlayer.create(this, R.raw.fear);
        player[1] = MediaPlayer.create(this, R.raw.happy);
        player[2] = MediaPlayer.create(this, R.raw.neutral);
        player[3] = MediaPlayer.create(this, R.raw.sad);

        Intent i = getIntent();
        int val = i.getIntExtra("emotion",0);
        emotion = val;

        result.setText(classes[emotion]);
    }

    public void play(View v) {
        if (player == null) {
            player[emotion].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player[emotion].start();
    }

    public void pause(View v) {
        if (player[emotion] != null) {
            player[emotion].pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player[emotion] != null) {
            player[emotion].release();
            player[emotion] = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
