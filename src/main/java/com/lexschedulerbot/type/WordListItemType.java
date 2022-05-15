package com.lexschedulerbot.type;

import com.google.gson.annotations.SerializedName;

public enum WordListItemType {
    @SerializedName("0")
    None(0, "Nothing found. Invalid element."),
    @SerializedName("1")
    ExactWord(1, "Exact match for word or phrase."),
    @SerializedName("2")
    LemmatizedVariant(2, "Lemmatized variant (word inflected form)."),
    @SerializedName("4")
    Subphrase(4, "Subphrase (lemmatized)."),
    @SerializedName("8")
    SpellingVariant(8, "Spelling vatiant."),
    @SerializedName("16")
    PrefixVariant(16, "Prefix variant (for last word of phrase).");

    private int value;
    private String desc;

    WordListItemType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
