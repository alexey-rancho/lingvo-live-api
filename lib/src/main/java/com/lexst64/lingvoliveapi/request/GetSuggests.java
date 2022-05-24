package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
import com.lexst64.lingvoliveapi.response.GetSuggestsResponse;
import org.jetbrains.annotations.NotNull;

public class GetSuggests extends BaseRequest<GetSuggests, GetSuggestsResponse> {

    public GetSuggests(@NotNull String text, @NotNull LangPair langPair) {
        this(text, langPair.getSrcLang(), langPair.getDstLang());
    }

    public GetSuggests(@NotNull String text, @NotNull Lang srcLang, @NotNull Lang dstLang) {
        super(GetSuggestsResponse.class);
        addQuery("text", text);
        addQuery("srcLang", srcLang.getCode());
        addQuery("dstLang", dstLang.getCode());
    }
}
