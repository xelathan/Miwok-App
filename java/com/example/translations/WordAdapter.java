package com.example.translations;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResource;

    public WordAdapter(Activity context, ArrayList<Word> words, int mColorResource) {
        super(context,0 ,words);
        colorResource = mColorResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        if(item == null) {
            item = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Word currentWord = getItem(position);

        TextView defaultTextView = (TextView) item.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTextView = (TextView) item.findViewById(R.id.miwok_text_view);

        miwokTextView.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) item.findViewById(R.id.image_view);


        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImage());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        LinearLayout background = (LinearLayout) item.findViewById(R.id.color_background);

        background.setBackgroundResource(colorResource);

        return item;
    }


}
