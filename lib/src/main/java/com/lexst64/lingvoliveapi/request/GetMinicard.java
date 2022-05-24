package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.response.GetMinicardResponse;
import org.jetbrains.annotations.NotNull;

public class GetMinicard extends BaseRequest<GetMinicard, GetMinicardResponse> {
    public GetMinicard() {
        super(GetMinicardResponse.class);
        setRequiredQueries("text", "srcLang", "dstLang");
    }

    public GetMinicard text(String text) {
        return addQuery("text", text);
    }

    public GetMinicard srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.getCode());
    }

    public GetMinicard dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.getCode());
    }
}
