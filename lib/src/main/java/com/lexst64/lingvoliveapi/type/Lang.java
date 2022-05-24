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

    private final int code;

    Lang(int langCode) {
        this.code = langCode;
    }

    public int getCode() {
        return code;
    }

    public static Lang getLangByCode(int code) {
        for (Lang lang : Lang.values()) {
            if (lang.code == code) {
                return lang;
            }
        }
        return null;
    }

    public static Lang getLangByCode(int code, Lang defaultValue) {
        for (Lang lang : Lang.values()) {
            if (lang.code == code) {
                return lang;
            }
        }
        return defaultValue;
    }
}
