package com.lexschedulerbot;

public enum Lang {
    UKRAINIAN(1058),
    RUSSIAN(1049),
    ENGLISH(1033),
    CHINESE(1028);

    private final int langCode;

    Lang(int langCode) {
        this.langCode = langCode;
    }

    public int code() {
        return langCode;
    }
}
