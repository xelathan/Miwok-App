package com.example.translations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    private MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("Father", "Epe", R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new Word("Mother", "Eta", R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("Son", "Angsi", R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("Daughter", "Tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("Older Brother", "Taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("Younger Brother", "Chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("Older Sister", "Tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("Younger Sister", "Kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("Grandmother", "Ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("Grandfather", "Paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter wordAdapter = new WordAdapter(this, familyMembers, R.color.green);

        ListView famMemList = (ListView) findViewById(R.id.list_family_members);

        famMemList.setAdapter(wordAdapter);

        famMemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word currentFamMem = familyMembers.get(i);
                if(audio != null) {
                    audio.release();
                    audio = null;
                }
                audio = MediaPlayer.create(FamilyMembersActivity.this, currentFamMem.getAudioResource());
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