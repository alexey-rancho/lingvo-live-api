package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
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

    public GetSearch(@NotNull String text,
                     @NotNull LangPair langPair,
                     @NotNull SearchZone searchZone,
                     int startIndex,
                     int pageSize
    ) {
        this(text, langPair.getSrcLang(), langPair.getDstLang(), searchZone, startIndex, pageSize);
    }

    public GetSearch(@NotNull String text,
                     @NotNull Lang srcLang,
                     @NotNull Lang dstLang,
                     @NotNull SearchZone searchZone,
                     int startIndex,
                     int pageSize
    ) {
        super(GetSearchResponse.class);
        addQuery("text", text);
        addQuery("srcLang", srcLang.getCode());
        addQuery("dstLang", dstLang.getCode());
        addQuery("searchZone", searchZone.getCode());
        addQuery("startIndex", startIndex);
        addQuery("pageSize", pageSize);
    }

    public static class Builder {
        private String text;
        private Lang srcLang;
        private Lang dstLang;
        private SearchZone searchZone;
        private int startIndex;
        private int pageSize;

        public Builder text(@NotNull String text) {
            this.text = text;
            return this;
        }

        public Builder langPair(@NotNull LangPair langPair) {
            this.srcLang = langPair.getSrcLang();
            this.dstLang = langPair.getDstLang();
            return this;
        }

        public Builder srcLang(@NotNull Lang srcLang) {
            this.srcLang = srcLang;
            return this;
        }

        public Builder dstLang(@NotNull Lang dstLang) {
            this.dstLang = dstLang;
            return this;
        }

        public Builder searchZone(@NotNull SearchZone searchZone) {
            this.searchZone = searchZone;
            return this;
        }

        public Builder startIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        public Builder pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public GetSearch build() {
            return new GetSearch(text, srcLang, dstLang, searchZone, startIndex, pageSize);
        }
    }
}
