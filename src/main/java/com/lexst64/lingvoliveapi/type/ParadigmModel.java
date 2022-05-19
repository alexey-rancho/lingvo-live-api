package com.lexst64.lingvoliveapi.type;

import java.util.Arrays;

public class ParadigmModel {

    private String Name;
    private String Grammar;
    private ParadigmGroupTransposed[] Groups;

    public String name() {
        return Name;
    }

    public String grammar() {
        return Grammar;
    }

    public ParadigmGroupTransposed[] groups() {
        return Groups;
    }

    @Override
    public String toString() {
        return "ParadigmModel{" +
                "name='" + Name + '\'' +
                ", grammar='" + Grammar + '\'' +
                ", groups=" + Arrays.toString(Groups) +
                '}';
    }
}
