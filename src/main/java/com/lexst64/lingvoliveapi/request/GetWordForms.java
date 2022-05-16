package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.response.GetWordFormsResponse;
import org.jetbrains.annotations.NotNull;

public class GetWordForms extends BaseRequest<GetWordForms, GetWordFormsResponse> {
    public GetWordForms() {
        super(GetWordFormsResponse.class);
    }
    
    public GetWordForms text(String text) {
        return addQuery("text", text);
    }

    public GetWordForms lang(@NotNull Lang lang) {
        return addQuery("lang", lang.code());
    }
}
