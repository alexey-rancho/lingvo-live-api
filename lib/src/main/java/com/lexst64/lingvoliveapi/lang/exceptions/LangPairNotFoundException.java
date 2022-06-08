package com.lexst64.lingvoliveapi.lang.exceptions;

import com.lexst64.lingvoliveapi.lang.Lang;

public class LangPairNotFoundException extends RuntimeException {

    public LangPairNotFoundException(Lang srcLang, Lang dstLang) {
        super(
                "lang pair not found by src lang '"
                        + srcLang.toString()
                        + "("
                        + srcLang.getCode()
                        + ")' and dst lang '"
                        + dstLang.toString()
                        + "("
                        + dstLang.getCode()
                        + ")'"
        );
    }
}
