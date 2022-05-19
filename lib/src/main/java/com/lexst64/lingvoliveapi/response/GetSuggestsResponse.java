package com.lexst64.lingvoliveapi.response;

import java.util.Arrays;

public class GetSuggestsResponse extends BaseResponse {
    private String[] suggests;

    public String[] suggests() {
        return suggests;
    }

    @Override
    public String toString() {
        return "GetSuggestsResponse{" +
                "suggests=" + Arrays.toString(suggests) +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
