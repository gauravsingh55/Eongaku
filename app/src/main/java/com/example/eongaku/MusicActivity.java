package com.example.eongaku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    TextView result;
    String[] classes = {"Fear", "Happy", "Nutral", "Sad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        result = findViewById(R.id.resutlView);

        Intent i = getIntent();
        int val = i.getIntExtra("emotion",0);

        result.setText(classes[val]);
    }
}