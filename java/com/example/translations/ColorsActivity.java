package com.example.translations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Word> ColorsList = new ArrayList<Word>();
        ColorsList.add(new Word("Red", "Weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        ColorsList.add(new Word("Green", "Chokokki", R.drawable.color_green, R.raw.color_green));
        ColorsList.add(new Word("Brown", "Takaakki", R.drawable.color_brown, R.raw.color_brown));
        ColorsList.add(new Word("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray));
        ColorsList.add(new Word("Black", "Kululli", R.drawable.color_black, R.raw.color_black));
        ColorsList.add(new Word("White", "Kelelli", R.drawable.color_white, R.raw.color_white));
        ColorsList.add(new Word("Dusty Yellow", "Topiise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        ColorsList.add(new Word("Mustard Yellow", "Chiwiiṭe", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter wordAdapter = new WordAdapter(this, ColorsList, R.color.purple);

        ListView colorListView = (ListView)findViewById(R.id.list_colors);

        colorListView.setAdapter(wordAdapter);

        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word currentColor = ColorsList.get(i);
                if(audio != null) {
                    audio.release();
                    audio = null;
                }
                audio = MediaPlayer.create(ColorsActivity.this, currentColor.getAudioResource());
                audio.start();
                audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if(audio != null) {
                            audio.release();
                            audio = null;
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(audio != null) {
            audio.release();
            audio = null;
        }
    }
}