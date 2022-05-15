package com.lexschedulerbot.request;

import com.lexschedulerbot.response.PostAuthenticateResponse;
import okhttp3.Headers;

public class PostAuthenticate extends BaseRequest<PostAuthenticate, PostAuthenticateResponse> {
    public PostAuthenticate(String apiKey) {
        super(PostAuthenticateResponse.class);
        addBasicHeader(apiKey);
    }
}

