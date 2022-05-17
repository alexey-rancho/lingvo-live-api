package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.LexemModel;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

public class LexemModelTest {
    public static void check(@NotNull LexemModel lexemModel) {
        Assertions.assertNotNull(lexemModel.lexem());
        Assertions.assertNotNull(lexemModel.partOfSpeech());
        ParadigmModelTest.check(lexemModel.paradigmJson());
    }
}

