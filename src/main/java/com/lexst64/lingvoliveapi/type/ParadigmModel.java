package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ParadigmModel {
    @SerializedName("Name")
    private String name;

    @SerializedName("Grammar")
    private String grammar;

    @SerializedName("Groups")
    private ParadigmGroupTransposed[] groups;

    public String getName() {
        return name;
    }

    public String getGrammar() {
        return grammar;
    }

    public ParadigmGroupTransposed[] getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "ParadigmModel{" +
                "name='" + name + '\'' +
                ", grammar='" + grammar + '\'' +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
