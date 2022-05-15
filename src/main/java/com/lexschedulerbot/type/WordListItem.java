package com.lexschedulerbot.type;

import com.google.gson.annotations.SerializedName;

public class WordListItem {
    @SerializedName("Heading")
    private String heading;
    @SerializedName("Translation")
    private String translation;
    @SerializedName("DictionaryName")
    private String dictionaryName;
    @SerializedName("SoundName")
    private String soundName;
    @SerializedName("Type")
    private WordListItemType type;
    @SerializedName("OriginalWord")
    private String originalWord;

    @Override
    public String toString() {
        return "WordListItem{" +
                "heading='" + heading + '\'' +
                ", translation='" + translation + '\'' +
                ", dictionaryName='" + dictionaryName + '\'' +
                ", soundName='" + soundName + '\'' +
                ", type=" + type +
                ", originalWord='" + originalWord + '\'' +
                '}';
    }
}
