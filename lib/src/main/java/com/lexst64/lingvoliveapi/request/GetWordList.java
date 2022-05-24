package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.lang.LangPair;
import com.lexst64.lingvoliveapi.response.GetWordListResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordList extends BaseRequest<GetWordList, GetWordListResponse>{

    public GetWordList(@NotNull String prefix, @NotNull LangPair langPair, int pageSize) {
        this(prefix, langPair.getSrcLang(), langPair.getDstLang(), pageSize);
    }

    public GetWordList(@NotNull String prefix, @NotNull Lang srcLang, @NotNull Lang dstLang, int pageSize) {
        super(GetWordListResponse.class);
        addQuery("prefix", prefix);
        addQuery("srcLang", srcLang.getCode());
        addQuery("dstLang", dstLang.getCode());
        addQuery("pageSize", pageSize);
    }

    public void startPos(String startPos) {
        addQuery("startPos", startPos);
    }
}
