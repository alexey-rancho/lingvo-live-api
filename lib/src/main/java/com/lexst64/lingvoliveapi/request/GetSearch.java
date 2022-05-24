package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.response.GetSearchResponse;
import com.lexst64.lingvoliveapi.LingvoLive;
import com.lexst64.lingvoliveapi.type.SearchZone;
import org.jetbrains.annotations.NotNull;

/**
 * @deprecated {@linkplain LingvoLive}'s execute method doesn't support this class's instance
 * because {@link GetSearchResponse} doesn't meet the json structure that api method
 * Search returns on request.
 */
@Deprecated
public class GetSearch extends BaseRequest<GetSearch, GetSearchResponse> {
    public GetSearch() {
        super(GetSearchResponse.class);
        setRequiredQueries("text", "srcLang", "dstLang", "searchZone", "startIndex", "pageSize");
    }

    public GetSearch text(String text) {
        return addQuery("text", text);
    }

    public GetSearch srcLang(@NotNull Lang srcLang) {
        return addQuery("srcLang", srcLang.getCode());
    }

    public GetSearch dstLang(@NotNull Lang dstLang) {
        return addQuery("dstLang", dstLang.getCode());
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
