package com.lexschedulerbot.request;

import com.lexschedulerbot.response.GetSoundResponse;

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
