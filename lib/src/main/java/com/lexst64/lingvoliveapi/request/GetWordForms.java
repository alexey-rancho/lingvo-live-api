package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.response.GetWordFormsResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordForms extends BaseRequest<GetWordForms, GetWordFormsResponse> {
    public GetWordForms(@NotNull String text, @NotNull Lang lang) {
        super(GetWordFormsResponse.class);
        addQuery("text", text);
        addQuery("lang", lang.getCode());
    }
}
