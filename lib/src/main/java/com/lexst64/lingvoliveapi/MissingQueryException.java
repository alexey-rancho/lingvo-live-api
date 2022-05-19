package com.lexst64.lingvoliveapi;

import java.util.MissingResourceException;

public class MissingQueryException extends MissingResourceException {
    public MissingQueryException(String className, String key) {
        super("required query " + "'" + key + "' not provided for " + className + " request", className, key);
    }
}
