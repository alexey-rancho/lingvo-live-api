package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

public enum WordListItemType {
    @SerializedName("0")
    NONE(0),

    @SerializedName("1")
    EXACT_WORD(1),

    @SerializedName("2")
    LEMMATIZED_VARIANTS(2),

    @SerializedName("4")
    SUBPHRASE(4),

    @SerializedName("8")
    SPELLING_VARIANT(8),

    @SerializedName("16")
    PREFIX_VARIANT(16);

    private final int code;

    WordListItemType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
