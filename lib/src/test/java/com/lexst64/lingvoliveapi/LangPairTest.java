package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
import com.lexst64.lingvoliveapi.lang.LangPairNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LangPairTest {
    @Test
    void testFindPairsBySrcLang() {
        LangPair[] actualPairs = LangPair.findPairsBySrcLang(Lang.EN);
        LangPair[] expectedPairs = {LangPair.EN_EN, LangPair.EN_RU, LangPair.EN_UK};

        Assertions.assertArrayEquals(expectedPairs, actualPairs);
    }

    @Test
    void testFindPairsByDstLang() {
        LangPair[] actualPairs = LangPair.findPairsByDstLang(Lang.CH);
        LangPair[] expectedPairs = {LangPair.CH_CH, LangPair.RU_CH};

        Assertions.assertArrayEquals(expectedPairs, actualPairs);
    }

    @Test
    void testGetSrcAndDstLang() {
        Assertions.assertEquals(Lang.EL, LangPair.EL_RU.getSrcLang());
        Assertions.assertEquals(Lang.RU, LangPair.EL_RU.getDstLang());
    }

    @Test
    void testGetSrcLangs() {
        Lang[] expectedSrcLangs = {Lang.CH, Lang.DE, Lang.EL, Lang.EN, Lang.ES, Lang.FR, Lang.IT, Lang.LA, Lang.RU, Lang.UK};
        Assertions.assertArrayEquals(expectedSrcLangs, LangPair.getSrcLangs());
    }

    @Test
    void testGetDstLangs() {
        Lang[] expectedDstLangs = {Lang.CH, Lang.RU, Lang.EN, Lang.UK, Lang.DE, Lang.EL, Lang.ES, Lang.FR, Lang.IT, Lang.KK};
        Assertions.assertArrayEquals(expectedDstLangs, LangPair.getDstLangs());
    }

    @Test
    void testGetPair() {
        Assertions.assertEquals(
                LangPair.CH_RU,
                LangPair.getPair(Lang.CH, Lang.RU)
        );
        Assertions.assertEquals(
                LangPair.EN_UK,
                LangPair.getPair(Lang.EN, Lang.UK)
        );
        Assertions.assertThrowsExactly(
                LangPairNotFoundException.class,
                () -> LangPair.getPair(Lang.EN, Lang.EL)
        );
    }
}
