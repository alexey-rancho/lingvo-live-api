package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LangPairTest {
    @Test
    void testFindPairsBySrcLang() {
        LangPair[] actualPairs = LangPair.findPairsBySrcLang(Lang.EN);
        LangPair[] expectedPairs = new LangPair[]{LangPair.EN_EN, LangPair.EN_RU, LangPair.EN_UK};

        Assertions.assertArrayEquals(expectedPairs, actualPairs);
    }

    @Test
    void testFindPairsByDstLang() {
        LangPair[] actualPairs = LangPair.findPairsByDstLang(Lang.CH);
        LangPair[] expectedPairs = new LangPair[]{LangPair.CH_CH, LangPair.RU_CH};

        Assertions.assertArrayEquals(expectedPairs, actualPairs);
    }

    @Test
    void testGetSrcAndDstLang() {
        Assertions.assertEquals(Lang.EL, LangPair.EL_RU.getSrcLang());
        Assertions.assertEquals(Lang.RU, LangPair.EL_RU.getDstLang());
    }
}
