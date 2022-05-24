package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.response.GetWordlistResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordlist extends BaseRequest<GetWordlist, GetWordlistResponse>{
    public GetWordlist() {
        super(GetWordlistResponse.class);
        setRequiredQueries("prefix", "srcLang", "dstLang", "pageSize");
    }

    public GetWordlist prefix(String prefix) {
        return addQuery("prefix", prefix);
    }

    public GetWordlist srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.getCode());
    }

    public GetWordlist dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.getCode());
    }

    public GetWordlist pageSize(int pageSize) {
        return addQuery("pageSize", pageSize);
    }

    public GetWordlist startPos(String startPos) {
        return addQuery("startPos", startPos);
    }
}
