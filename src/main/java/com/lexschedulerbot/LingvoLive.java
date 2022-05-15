package com.lexschedulerbot;

import com.google.gson.Gson;
import com.lexschedulerbot.request.*;
import com.lexschedulerbot.response.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LingvoLive {

    private static final String API_V1_URL = "https://developers.lingvolive.com/api/v1/";
    private static final String API_V1_1_URL = "https://developers.lingvolive.com/api/v1.1/";

    private final String apiKey;
    private final OkHttpClient client;
    private final Gson gson;

    private String bearerToken;

    public LingvoLive(@NotNull String apiKey) {
        if (apiKey.length() == 0) {
            throw new IllegalArgumentException("apiKey mustn't be empty");
        }
        this.apiKey = apiKey;
        client = new OkHttpClient();
        gson = new Gson();
        bearerToken = authenticate();
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        R response = send(request);
        if (response.getCode() == 401) {
            bearerToken = authenticate();
            return send(request);
        }
        return response;
    }

    private <T extends BaseRequest<T, R>, R extends BaseResponse> R send(BaseRequest<T, R> request) {
        try (Response response = client.newCall(createRequest(request)).execute()) {
            System.out.println(response.code());
            String json = response.body().string();
            if (request instanceof GetSuggests) {
                json = "{suggests: " + json + "}";
            }
            if (request instanceof GetWordForms) {
                json = "{lexemModels: " + json + "}";
            }

            if (response.code() >= 200 && response.code() < 300) {
                R successResponse = gson.fromJson(json, request.getResponseType());
                successResponse.setCode(response.code())
                        .setOk(response.isSuccessful())
                        .setMessage(response.message());
                return successResponse;
            } else {
                json = createBaseJson(response.isSuccessful(), response.code(), response.message());
                return gson.fromJson(json, request.getResponseType());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createBaseJson(boolean isOk, int code, String message) {
        return String.format("{\"isOk\": \"%b\"; \"code\": \"%d\"; \"message\": \"%s\"}", isOk, code, message);
    }

    private Request createRequest(BaseRequest<?, ?> request) {
        return new Request.Builder()
                .header("Authorization", "Bearer " + bearerToken)
                .url(API_V1_URL + request.getMethod() + createQueryString(request))
                .build();
    }

    private String createQueryString(BaseRequest<?, ?> request) {
        List<String> queries = new ArrayList<>();
        for (Map.Entry<String, Object> query : request.getQueries().entrySet()) {
            queries.add(query.getKey() + "=" + query.getValue());
        }
        return "?" + String.join("&", queries);
    }

    private String authenticate() throws AuthorizationException {
        Request request = new Request.Builder()
                .post(new FormBody.Builder().build())
                .header("Authorization", "Basic " + apiKey)
                .url(API_V1_1_URL + "authenticate")
                .build();
        try(Response response = client.newCall(request).execute()) {
            if (response.code() == 401) {
                throw new AuthorizationException("Invalid api key");
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
