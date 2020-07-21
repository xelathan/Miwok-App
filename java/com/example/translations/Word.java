package com.example.translations;

public class Word {
    private String defaultWord;
    private String miwokWord;
    private int audioResource;
    private int image =-1;
    private final static int No_Image_Provided = -1;

    public Word(String defaultword, String miwok, int imageView, int audio) {
        defaultWord = defaultword;
        miwokWord = miwok;
        image = imageView;
        audioResource = audio;
    }

    public Word(String defaultword, String miwok, int audio) {
        defaultWord = defaultword;
        miwokWord = miwok;
        audioResource = audio;
    }

    public String getDefaultTranslation() {
        return defaultWord;
    }

    public String getMiwokTranslation() {
        return miwokWord;
    }

    public int getImage(){
        return image;
    }

    public boolean hasImage() {
        return image != No_Image_Provided;
    }

    public int getAudioResource() {
        return audioResource;
    }

}
