package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.Lang;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LangTest {
    @Test
    void testGetLangByCode() {
        Assertions.assertEquals(Lang.UKRAINIAN, Lang.getLangByCode(Lang.UKRAINIAN.getCode()));
        Assertions.assertNull(Lang.getLangByCode(1));
        Assertions.assertEquals(Lang.ENGLISH, Lang.getLangByCode(2, Lang.ENGLISH));
        Assertions.assertEquals(Lang.UKRAINIAN, Lang.getLangByCode(Lang.UKRAINIAN.getCode(), Lang.ENGLISH));
    }
}
