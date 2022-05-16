package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.response.GetWordlistResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordlist extends BaseRequest<GetWordlist, GetWordlistResponse>{
    public GetWordlist() {
        super(GetWordlistResponse.class);
    }

    public GetWordlist prefix(String prefix) {
        return addQuery("prefix", prefix);
    }

    public GetWordlist srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.code());
    }

    public GetWordlist dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.code());
    }

    public GetWordlist pageSize(int pageSize) {
        return addQuery("pageSize", pageSize);
    }

    public GetWordlist startPos(String startPos) {
        return addQuery("startPos", startPos);
    }
}
