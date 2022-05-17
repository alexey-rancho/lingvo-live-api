package com.lexst64.lingvoliveapi.type;

import java.util.Arrays;
import java.util.Objects;

public class ParadigmGroupTransposed {

    private String Name;
    private ParadigmForm[][] Table;
    private int ColumnCount;
    private int RowCount;

    public String name() {
        return Name;
    }

    public ParadigmForm[][] table() {
        return Table;
    }

    public int columnCount() {
        return ColumnCount;
    }

    public int rowCount() {
        return RowCount;
    }

    @Override
    public String toString() {
        return "ParadigmGroupTransposed{" +
                "name='" + Name + '\'' +
                ", table=" + Arrays.deepToString(Table) +
                ", columnCount=" + ColumnCount +
                ", rowCount=" + RowCount +
                '}';
    }
}
