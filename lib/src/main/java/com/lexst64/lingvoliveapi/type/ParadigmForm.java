package com.lexst64.lingvoliveapi.type;

import java.util.Objects;

public class ParadigmForm {

    private String Value;
    private String Prefix;
    private String Row;

    public String value() {
        return Value;
    }

    public String prefix() {
        return Prefix;
    }

    public String row() {
        return Row;
    }

    @Override
    public String toString() {
        return "ParadigmForm{" +
                "value='" + Value + '\'' +
                ", prefix='" + Prefix + '\'' +
                ", row='" + Row + '\'' +
                '}';
    }
}
