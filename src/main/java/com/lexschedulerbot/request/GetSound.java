package com.lexschedulerbot.request;

import com.lexschedulerbot.response.GetSoundResponse;

public class GetSound extends BaseRequest<GetSound, GetSoundResponse>{
    public GetSound(String bearerToken) {
        super(GetSoundResponse.class);
        addBearerHeader(bearerToken);
    }

    public GetSound dictionaryName(String dictionaryName) {
        addQuery("dictionaryName", dictionaryName);
        return this;
    }

    public GetSound fileName(String fileName) {
        addQuery("fileName", fileName);
        return this;
    }
}
