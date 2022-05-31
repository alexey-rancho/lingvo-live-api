package com.lexst64.lingvoliveapi.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum LangPair {
    CH_CH(Lang.CH, Lang.CH),
    CH_RU(Lang.CH, Lang.RU),

    DE_RU(Lang.DE, Lang.RU),

    EL_RU(Lang.EL, Lang.RU),

    EN_EN(Lang.EN, Lang.EN),
    EN_RU(Lang.EN, Lang.RU),
    EN_UK(Lang.EN, Lang.UK),

    ES_RU(Lang.ES, Lang.RU),

    FR_RU(Lang.FR, Lang.RU),

    IT_RU(Lang.IT, Lang.RU),

    LA_RU(Lang.LA, Lang.RU),

    RU_CH(Lang.RU, Lang.CH),
    RU_DE(Lang.RU, Lang.DE),
    RU_EL(Lang.RU, Lang.EL),
    RU_EN(Lang.RU, Lang.EN),
    RU_ES(Lang.RU, Lang.ES),
    RU_FR(Lang.RU, Lang.FR),
    RU_IT(Lang.RU, Lang.IT),
    RU_KK(Lang.RU, Lang.KK),
    RU_RU(Lang.RU, Lang.RU),
    RU_UK(Lang.RU, Lang.UK),

    UK_EN(Lang.UK, Lang.EN),
    UK_RU(Lang.UK, Lang.RU),
    UK_UK(Lang.UK, Lang.UK);

    private static final Lang[] srcLangs;
    private static final Lang[] dstLangs;

    static {
        srcLangs = Arrays.stream(values()).map(LangPair::getSrcLang).distinct().toArray(Lang[]::new);
        dstLangs = Arrays.stream(values()).map(LangPair::getDstLang).distinct().toArray(Lang[]::new);
    }

    /**
     * @return array of all available source languages for the existing lang pairs
     * */
    public static Lang[] getSrcLangs() {
        return srcLangs;
    }

    /**
     * @return array of all available destination languages for the existing lang pairs
     * */
    public static Lang[] getDstLangs() {
        return dstLangs;
    }

    private final Lang srcLang;
    private final Lang dstLang;

    LangPair(Lang srcLang, Lang dstLang) {
        this.srcLang = srcLang;
        this.dstLang = dstLang;
    }

    public Lang getSrcLang() {
        return srcLang;
    }

    public Lang getDstLang() {
        return dstLang;
    }

    public static LangPair[] findPairsBySrcLang(Lang srcLang) {
        return findPairsByLang(srcLang, LangType.SRC_LANG);
    }

    public static LangPair[] findPairsByDstLang(Lang dstLang) {
        return findPairsByLang(dstLang, LangType.DST_LANG);
    }

    private static LangPair[] findPairsByLang(Lang lang, LangType langType) {
        List<LangPair> pairs = new ArrayList<>();
        for (LangPair pair : LangPair.values()) {
            if (langType == LangType.SRC_LANG && pair.srcLang == lang) {
                pairs.add(pair);
            } else if (langType == LangType.DST_LANG && pair.dstLang == lang) {
                pairs.add(pair);
            }
        }
        return pairs.toArray(LangPair[]::new);
    }
}
