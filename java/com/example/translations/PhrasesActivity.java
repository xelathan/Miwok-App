package com.example.translations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer audio;
    private AudioManager AM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        AM = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> phraseList = new ArrayList<Word>();

        phraseList.add(new Word("Where are you going?", "Minto wuksus", R.raw.phrase_where_are_you_going));
        phraseList.add(new Word("What is your name?", "Tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        phraseList.add(new Word("My name is...", "Oyaaset...", R.raw.phrase_my_name_is));
        phraseList.add(new Word("How are you feeling?", "Michәkses?", R.raw.phrase_how_are_you_feeling));
        phraseList.add(new Word("I’m feeling good.", "Kuchi achit", R.raw.phrase_im_feeling_good));
        phraseList.add(new Word("Are you coming?", "Eenes'aa?", R.raw.phrase_are_you_coming));
        phraseList.add(new Word("Yes, I’m coming.", "Hee’ eenem", R.raw.phrase_yes_im_coming));
        phraseList.add(new Word("I’m coming.", "Eenem", R.raw.phrase_im_coming));
        phraseList.add(new Word("Let’s go.", "Yoowutis", R.raw.phrase_lets_go));
        phraseList.add(new Word("Come here.", "enni'nem", R.raw.phrase_come_here));

        WordAdapter wordAdapter = new WordAdapter(this, phraseList, R.color.blue);

        ListView phraseListView = (ListView)findViewById(R.id.list_phrases);

        phraseListView.setAdapter(wordAdapter);

        phraseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word phrase = phraseList.get(i);
                if(audio != null) {
                    audio.release();
                    audio = null;
                }
                audio = MediaPlayer.create(PhrasesActivity.this, phrase.getAudioResource());
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
    }}