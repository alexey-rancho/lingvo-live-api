package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.ParadigmGroupTransposed;
import com.lexst64.lingvoliveapi.type.ParadigmModel;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ParadigmModelTest {
    public static void check(@NotNull ParadigmModel paradigmModel) {
        Assertions.assertNotNull(paradigmModel.name());
        Assertions.assertNotNull(paradigmModel.grammar());
        for (ParadigmGroupTransposed group : paradigmModel.groups()) {
            ParadigmGroupTransposedTest.check(group);
        }
    }
}
