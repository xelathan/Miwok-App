package com.example.translations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer audio;
    private AudioManager am;

    AudioManager.OnAudioFocusChangeListener amListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                audio.pause();
                audio.seekTo(0);
            }
            else if(i == AudioManager.AUDIOFOCUS_GAIN) {
                audio.start();
            }
            else if(i == AudioManager.AUDIOFOCUS_LOSS) {
                audio.release();
                audio = null;
                am.abandonAudioFocus(amListener);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("One", "Lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("Two", "Ottiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, numbers, R.color.gold);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = numbers.get(i);
                    if(audio != null) {
                        audio.release();
                        audio = null;
                    }
                    audio = MediaPlayer.create(NumbersActivity.this, word.getAudioResource());
                    audio.start();
                    audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if(audio != null){
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