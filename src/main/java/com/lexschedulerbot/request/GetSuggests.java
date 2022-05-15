package com.lexschedulerbot.request;

import com.lexschedulerbot.Lang;
import com.lexschedulerbot.response.GetSuggestsResponse;
import org.jetbrains.annotations.NotNull;

public class GetSuggests extends BaseRequest<GetSuggests, GetSuggestsResponse> {
    public GetSuggests(String bearerToken) {
        super(GetSuggestsResponse.class);
        addBearerHeader(bearerToken);
    }

    public GetSuggests text(String text) {
        addQuery("text", text);
        return this;
    }

    public GetSuggests srcLang(@NotNull Lang srcLang) {
        addQuery("srcLang", srcLang.code());
        return this;
    }

    public GetSuggests dstLang(@NotNull Lang dstLang) {
        addQuery("dstLang", dstLang.code());
        return this;
    }
}
