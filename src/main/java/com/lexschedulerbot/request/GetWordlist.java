package com.lexschedulerbot.request;

import com.lexschedulerbot.Lang;
import com.lexschedulerbot.RequiredParam;
import com.lexschedulerbot.response.GetWordlistResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordlist extends BaseRequest<GetWordlist, GetWordlistResponse>{
    public GetWordlist() {
        super(GetWordlistResponse.class);
    }

    @RequiredParam
    public GetWordlist prefix(String prefix) {
        return addQuery("prefix", prefix);
    }

    @RequiredParam
    public GetWordlist srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.code());
    }

    @RequiredParam
    public GetWordlist dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.code());
    }

    @RequiredParam
    public GetWordlist pageSize(int pageSize) {
        return addQuery("pageSize", pageSize);
    }

    public GetWordlist startPos(String startPos) {
        return addQuery("startPos", startPos);
    }
}
