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

        //Initialize all the songs for each emotion
        player[0] = MediaPlayer.create(this, R.raw.fear);
        player[1] = MediaPlayer.create(this, R.raw.happy);
        player[2] = MediaPlayer.create(this, R.raw.neutral);
        player[3] = MediaPlayer.create(this, R.raw.sad);

        //Get the result of the classification
        Intent i = getIntent();
        int val = i.getIntExtra("emotion",0);
        emotion = val;

        //Setting the emotion in the TextField
        result.setText(classes[emotion]);
    }

    //Function for the play button
    public void play(View v) {
        if (player == null) {
            player[emotion].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                //Stop the media player if the song ends
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player[emotion].start();
    }

    //Function for the pause button
    public void pause(View v) {
        if (player[emotion] != null) {
            player[emotion].pause();
        }
    }

    //Function for the stop button
    public void stop(View v) {
        stopPlayer();
    }

    //Function to release and stop the MediaPlayer class
    private void stopPlayer() {
        if (player[emotion] != null) {
            player[emotion].release();
            player[emotion] = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    //MediaPlayer must stop if the activity closes
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
