package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.ParadigmForm;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class ParadigmFormTest {
    public static void check(@NotNull ParadigmForm paradigmForm) {
        Assertions.assertNotNull(paradigmForm.value());
        Assertions.assertTrue(paradigmForm.prefix() != null || paradigmForm.prefix() == null);
        Assertions.assertNull(paradigmForm.row());
    }
}
