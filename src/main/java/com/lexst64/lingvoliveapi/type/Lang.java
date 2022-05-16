package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

public enum Lang {
    @SerializedName("1058")
    UKRAINIAN(1058),

    @SerializedName("1049")
    RUSSIAN(1049),

    @SerializedName("1033")
    ENGLISH(1033),

    @SerializedName("1028")
    CHINESE(1028);

    private final int langCode;

    Lang(int langCode) {
        this.langCode = langCode;
    }

    public int code() {
        return langCode;
    }
}
