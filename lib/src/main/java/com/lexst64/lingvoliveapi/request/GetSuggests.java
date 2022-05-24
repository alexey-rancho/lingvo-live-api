package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.response.GetSuggestsResponse;
import org.jetbrains.annotations.NotNull;

public class GetSuggests extends BaseRequest<GetSuggests, GetSuggestsResponse> {
    public GetSuggests() {
        super(GetSuggestsResponse.class);
        setRequiredQueries("text", "srcLang", "dstLang");
    }

    public GetSuggests text(String text) {
        return addQuery("text", text);
    }

    public GetSuggests srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.getCode());
    }

    public GetSuggests dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.getCode());
    }
}
