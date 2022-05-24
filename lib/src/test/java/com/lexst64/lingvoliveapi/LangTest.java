package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.lang.Lang;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LangTest {
    @Test
    void testGetLangByCode() {
        Assertions.assertEquals(Lang.UK, Lang.getLangByCode(Lang.UK.getCode()));
        Assertions.assertNull(Lang.getLangByCode(1));
        Assertions.assertEquals(Lang.EN, Lang.getLangByCode(2, Lang.EN));
        Assertions.assertEquals(Lang.UK, Lang.getLangByCode(Lang.UK.getCode(), Lang.EN));
    }
}
