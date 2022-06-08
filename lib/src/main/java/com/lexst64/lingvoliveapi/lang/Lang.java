package com.lexst64.lingvoliveapi.lang;

import com.google.gson.annotations.SerializedName;
import com.lexst64.lingvoliveapi.lang.exceptions.LangNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Lang {
    @SerializedName("1058")
    UK(1058),

    @SerializedName("1049")
    RU(1049),

    @SerializedName("1033")
    EN(1033),

    @SerializedName("1028")
    CH(1028),

    @SerializedName("1031")
    DE(1031),

    @SerializedName("1032")
    EL(1032),

    @SerializedName("1034")
    ES(1034),

    @SerializedName("1036")
    FR(1036),

    @SerializedName("1040")
    IT(1040),

    @SerializedName("1142")
    LA(1142),

    @SerializedName("1087")
    KK(1087);

    private final int code;

    Lang(int langCode) {
        this.code = langCode;
    }

    public int getCode() {
        return code;
    }

    public static Lang getLangByCode(int code) throws LangNotFoundException {
        return _getLangByCode(code, null);
    }

    public static Lang getLangByCode(int code, @NotNull Lang defaultValue) {
        return _getLangByCode(code, defaultValue);
    }

    private static Lang _getLangByCode(int code, @Nullable Lang defaultValue) {
        for (Lang lang : values()) {
            if (lang.code == code) {
                return lang;
            }
        }
        if (defaultValue != null) {
            return defaultValue;
        }
        throw new LangNotFoundException(code);
    }
}
