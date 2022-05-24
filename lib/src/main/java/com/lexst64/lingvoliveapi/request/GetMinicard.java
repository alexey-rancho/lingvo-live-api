package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
import com.lexst64.lingvoliveapi.response.GetMinicardResponse;
import org.jetbrains.annotations.NotNull;

public class GetMinicard extends BaseRequest<GetMinicard, GetMinicardResponse> {

    public GetMinicard(@NotNull String text, @NotNull LangPair langPair) {
        this(text, langPair.getSrcLang(), langPair.getDstLang());
    }

    public GetMinicard(@NotNull String text, @NotNull Lang srcLang, @NotNull Lang dstLang) {
        super(GetMinicardResponse.class);
        addQuery("text", text);
        addQuery("srcLang", srcLang.getCode());
        addQuery("dstLang", dstLang.getCode());
    }
}
