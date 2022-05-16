package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.response.GetSearchResponse;
import com.lexst64.lingvoliveapi.type.SearchZone;
import org.jetbrains.annotations.NotNull;

public class GetSearch extends BaseRequest<GetSearch, GetSearchResponse> {
    public GetSearch() {
        super(GetSearchResponse.class);
    }

    public GetSearch text(String text) {
        return addQuery("text", text);
    }

    public GetSearch srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.code());
    }

    public GetSearch dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.code());
    }

    public GetSearch searchZone(@NotNull SearchZone searchZone) {
        return addQuery("searchZone", searchZone.code());
    }

    public GetSearch startIndex(int startIndex) {
        return addQuery("startIndex", startIndex);
    }

    public GetSearch pageSize(int pageSize) {
        return addQuery("pageSize", pageSize);
    }
}
