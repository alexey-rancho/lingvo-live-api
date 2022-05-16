package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ParadigmGroupTransposed {
    @SerializedName("Name")
    private String name;

    @SerializedName("Table")
    private ParadigmForm[][] table;

    @SerializedName("ColumnCount")
    private int columnCount;

    @SerializedName("RowCount")
    private int rowCount;

    public String getName() {
        return name;
    }

    public ParadigmForm[][] getTable() {
        return table;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    @Override
    public String toString() {
        return "ParadigmGroupTransposed{" +
                "name='" + name + '\'' +
                ", table=" + Arrays.deepToString(table) +
                ", columnCount=" + columnCount +
                ", rowCount=" + rowCount +
                '}';
    }
}
