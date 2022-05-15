package com.lexschedulerbot.request;

import com.lexschedulerbot.Lang;
import com.lexschedulerbot.RequiredParam;
import com.lexschedulerbot.response.GetWordlistResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordlist extends BaseRequest<GetWordlist, GetWordlistResponse>{
    public GetWordlist(String bearerToken) {
        super(GetWordlistResponse.class);
        addBearerHeader(bearerToken);
    }

    @RequiredParam
    public GetWordlist prefix(String prefix) {
        addQuery("prefix", prefix);
        return this;
    }

    @RequiredParam
    public GetWordlist srcLang(@NotNull Lang srcLang) {
        addQuery("srcLang", srcLang.code());
        return this;
    }

    @RequiredParam
    public GetWordlist dstLang(@NotNull Lang dstLang) {
        addQuery("dstLang", dstLang.code());
        return this;
    }

    @RequiredParam
    public GetWordlist pageSize(int pageSize) {
        addQuery("pageSize", pageSize);
        return this;
    }

    public GetWordlist startPos(String startPos) {
        addQuery("startPos", startPos);
        return this;
    }
}
