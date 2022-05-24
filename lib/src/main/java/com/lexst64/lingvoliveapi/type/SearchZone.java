package com.lexst64.lingvoliveapi.type;

public enum SearchZone {
    HEADING(1),
    TRANSLATION(2),
    EXAMPLE(4),
    AUTO_SEARCH(7),
    COMMENT(8),
    ALL(15);

    private final int code;

    SearchZone(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
