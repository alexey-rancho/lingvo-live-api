package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.request.BaseRequest;
import com.lexst64.lingvoliveapi.response.BaseResponse;
import org.jetbrains.annotations.NotNull;

public class LingvoLive {

    private final LingvoLiveClient client;

    public LingvoLive(@NotNull String apiKey) throws AuthenticationException {
        client = new LingvoLiveClient(apiKey);
    }

    public String getApiKey() {
        return client.getApiKey();
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return client.send(request);
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback) {
        client.send(request, callback);
    }

}
