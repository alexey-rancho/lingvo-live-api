package com.lexschedulerbot.type;

import com.google.gson.annotations.SerializedName;

public class ParadigmForm {
    @SerializedName("Value")
    private String value;

    @SerializedName("Prefix")
    private String prefix;

    @SerializedName("Row")
    private String row;

    public String getValue() {
        return value;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "ParadigmForm{" +
                "value='" + value + '\'' +
                ", prefix='" + prefix + '\'' +
                ", row='" + row + '\'' +
                '}';
    }
}
