package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.response.GetSoundResponse;

public class GetSound extends BaseRequest<GetSound, GetSoundResponse>{
    public GetSound() {
        super(GetSoundResponse.class);
    }

    public GetSound dictionaryName(String dictionaryName) {
        return addQuery("dictionaryName", dictionaryName);
    }

    public GetSound fileName(String fileName) {
        return addQuery("fileName", fileName);
    }
}
