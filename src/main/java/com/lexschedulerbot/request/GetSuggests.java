package com.lexschedulerbot.request;

import com.lexschedulerbot.Lang;
import com.lexschedulerbot.response.GetSuggestsResponse;
import org.jetbrains.annotations.NotNull;

public class GetSuggests extends BaseRequest<GetSuggests, GetSuggestsResponse> {
    public GetSuggests() {
        super(GetSuggestsResponse.class);
    }

    public GetSuggests text(String text) {
        return addQuery("text", text);
    }

    public GetSuggests srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.code());
    }

    public GetSuggests dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.code());
    }
}
