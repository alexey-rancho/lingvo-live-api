package com.lexschedulerbot.request;

import com.lexschedulerbot.Lang;
import com.lexschedulerbot.response.GetMinicardResponse;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;

public class GetMinicard extends BaseRequest<GetMinicard, GetMinicardResponse> {
    public GetMinicard(String bearerToken) {
        super(GetMinicardResponse.class);
        addBearerHeader(bearerToken);
    }

    public GetMinicard text(String text) {
        return addQuery("text", text);
    }

    public GetMinicard srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.code());
    }

    public GetMinicard dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.code());
    }
}
