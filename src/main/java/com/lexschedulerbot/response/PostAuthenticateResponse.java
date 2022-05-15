package com.lexschedulerbot.response;

public class PostAuthenticateResponse extends BaseResponse {
    private String bearerToken;

    PostAuthenticateResponse() {

    }

    public String bearerToken() {
        return bearerToken;
    }

    @Override
    public String toString() {
        return "PostAuthenticateResponse{" +
                "bearerToken=" + bearerToken + "}";
    }
}
