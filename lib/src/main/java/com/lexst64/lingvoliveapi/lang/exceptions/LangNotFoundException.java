package com.lexst64.lingvoliveapi.lang.exceptions;

public class LangNotFoundException extends RuntimeException {
    public LangNotFoundException(int langCode) {
        super("no language has been found by '" + langCode + "' code");
    }
}
