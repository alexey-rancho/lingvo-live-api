package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.ParadigmForm;
import com.lexst64.lingvoliveapi.type.ParadigmGroupTransposed;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ParadigmGroupTransposedTest {
    public static void check(@NotNull ParadigmGroupTransposed group) {
        Assertions.assertNotNull(group.name());
        for (ParadigmForm[] paradigmForms : group.table()) {
            for (ParadigmForm paradigmForm : paradigmForms) {
                ParadigmFormTest.check(paradigmForm);
            }
        }
    }
}
