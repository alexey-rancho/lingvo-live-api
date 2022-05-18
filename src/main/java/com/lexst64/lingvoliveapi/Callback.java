package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.request.BaseRequest;
import com.lexst64.lingvoliveapi.response.BaseResponse;

import java.io.IOException;

public interface Callback<T extends BaseRequest<T, R>, R extends BaseResponse> {

    void onResponse(T request, R response);

    void onFailure(T request, IOException e);

}
