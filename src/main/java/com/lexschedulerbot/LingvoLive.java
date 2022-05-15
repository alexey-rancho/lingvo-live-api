package com.lexschedulerbot;

import com.google.gson.Gson;
import com.lexschedulerbot.request.*;
import com.lexschedulerbot.response.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;

public class LingvoLive {

    private static final String API_URL = "https://developers.lingvolive.com/api/v1/";
    private static final String SCHEME = "https";
    private static final String HOST = "developers.lingvolive.com";
    private static final String API_V1_PATH = "api/v1/";
    private static final String API_V1_1_PATH = "api/v1.1/";

    private final String apiKey;
    private final OkHttpClient client;
    private final Gson gson;

    private String bearerToken;

    public LingvoLive(String apiKey) {
        if (apiKey == null || apiKey.length() == 0) {
            throw new IllegalArgumentException("apiKey mustn't be null or empty");
        }
        this.apiKey = apiKey;
        client = new OkHttpClient();
        gson = new Gson();
        bearerToken = authenticate();
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        if (request instanceof PostAuthenticate) {
            return send(request);
        }
        if (!request.containsBearerHeader()) {
            request.addBearerHeader(bearerToken);
        }
        R response = send(request);
        if (response.getCode() == 401) {
            bearerToken = authenticate();
            request.addBearerHeader(bearerToken);
            return send(request);
        }
        return response;
    }

    private <T extends BaseRequest<T, R>, R extends BaseResponse> R send(BaseRequest<T, R> request) {
        try (Response response = client.newCall(createRequest(request)).execute()) {
            System.out.println(response.code());
            String json = response.body().string();
            if (request instanceof PostAuthenticate) {
                json = "{bearerToken: " + json + "}";
            }
            if (request instanceof GetSuggests) {
                json = "{suggests: " + json + "}";
            }
            if (request instanceof GetWordForms) {
                json = "{lexemModels: " + json + "}";
            }
            // todo: process fail requests
            if (response.code() >= 200 && response.code() < 300) {
                // todo: json exception
                R successResponse = gson.fromJson(json, request.getResponseType());
                successResponse.setCode(response.code())
                        .setOk(response.isSuccessful())
                        .setMessage(response.message());
                return successResponse;
            } else {
                String errJson = createBaseJson(response.isSuccessful(), response.code(), response.message());
                return gson.fromJson(errJson, request.getResponseType());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createBaseJson(boolean isOk, int code, String message) {
        return String.format("{\"isOk\": \"%b\"; \"code\": \"%d\"; \"message\": \"%s\"}", isOk, code, message);
    }

    private Request createRequest(BaseRequest<?, ?> request) {
        HttpUrl.Builder urlBuilder = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST);
        if (request instanceof PostAuthenticate) {
            urlBuilder.addPathSegments(API_V1_1_PATH);
        } else {
            urlBuilder.addPathSegments(API_V1_PATH);
        }
        urlBuilder.addPathSegment(request.getApiMethod());

        Request.Builder requestBuilder = new Request.Builder()
                .method(request.getHttpMethod(), new FormBody.Builder().build());
        for (Map.Entry<String, String> header : request.getHeaders().entrySet()) {
            requestBuilder.header(header.getKey(), header.getValue());
        }
        for (Map.Entry<String, Object> query : request.getQueries().entrySet()) {
            urlBuilder.addQueryParameter(query.getKey(), query.getValue().toString());
        }
        return requestBuilder.url(urlBuilder.build()).build();
    }

    private String authenticate() throws AuthorizationException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(API_V1_1_PATH)
                .addPathSegment("authenticate")
                .build();
        Request request = new Request.Builder()
                .post(new FormBody.Builder().build())
                .header("Authorization", "Basic " + apiKey)
                .url(url)
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
