package com.lexst64.lingvoliveapi;

import com.google.gson.Gson;
import com.lexst64.lingvoliveapi.request.BaseRequest;
import com.lexst64.lingvoliveapi.request.GetSuggests;
import com.lexst64.lingvoliveapi.request.GetWordForms;
import com.lexst64.lingvoliveapi.response.BaseResponse;
import okhttp3.OkHttpClient;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.Call;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LingvoLiveClient {

    private static final String API_V1_URL = "https://developers.lingvolive.com/api/v1/";
    private static final String API_V1_1_URL = "https://developers.lingvolive.com/api/v1.1/";

    private final String apiKey;
    private final OkHttpClient httpClient;
    private final Gson gson;

    private String bearerToken;

    public LingvoLiveClient(String apiKey) {
        this(apiKey, null, new Gson());
    }

    public LingvoLiveClient(String apiKey, @Nullable OkHttpClient httpClient, Gson gson) {
        this.apiKey = apiKey;
        this.httpClient = httpClient == null ? getOkHttpClient() : httpClient;
        this.gson = gson;
        bearerToken = authenticate();
    }

    public String getApiKey() {
        return apiKey;
    }

    /**
     * @throws MissingQueryException if required query hasn't been set for
     * the provided request
     * */
    public <T extends BaseRequest<T, R>, R extends BaseResponse> void send(final T request, final Callback<T, R> callback) {
        httpClient.newCall(createRequest(request)).enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                R result = null;
                Exception exception = null;

                try {
                    result = createResponse(request, response);
                } catch (Exception e) {
                    exception = e;
                }

                if (result != null) {
                    callback.onResponse(request, result);
                } else if (exception != null) {
                    callback.onFailure(request, exception instanceof IOException ? (IOException) exception : new IOException(exception));
                } else {
                    callback.onFailure(request, new IOException("response json is null or empty"));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(request, e);
            }
        });
    }

    /**
     * @throws MissingQueryException if required query hasn't been set for
     * the provided request
     * */
    public <T extends BaseRequest<T, R>, R extends BaseResponse> R send(final BaseRequest<T, R> request) {
        try (Response response = httpClient.newCall(createRequest(request)).execute()) {
            return createResponse(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .authenticator(getAuthenticator())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    private Authenticator getAuthenticator() {
        return new Authenticator() {
            @Override
            public Request authenticate(Route route, @NotNull Response response) {
                String header = response.request().header("Authorization");
                if (header == null || !header.startsWith("Bearer")) {
                    return null;
                }
                if (responseCount(response) > 2) {
                    return null;
                }
                bearerToken = LingvoLiveClient.this.authenticate();
                return response.request().newBuilder()
                        .header("Authorization", "Bearer " + bearerToken)
                        .build();
            }

            private int responseCount(Response response) {
                int result = 1;
                while ((response = response.priorResponse()) != null) {
                    result++;
                }
                return result;
            }
        };
    }

    private String authenticate() throws AuthenticationException {
        Request request = new Request.Builder()
                .post(new FormBody.Builder().build())
                .header("Authorization", "Basic " + apiKey)
                .url(API_V1_1_URL + "authenticate")
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 401) {
                throw new AuthenticationException("invalid api key");
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private <T extends BaseRequest<T, R>, R extends BaseResponse> R createResponse(BaseRequest<T, R> request, Response response) throws IOException {
        String json = response.body().string();

        if (request instanceof GetSuggests) json = "{suggests: " + json + "}";
        if (request instanceof GetWordForms) json = "{lexemModels: " + json + "}";

        if (response.code() < 200 || response.code() >= 300) {
            json = createJsonOnError(response.code(), response.message(), json);
        }
        return gson.fromJson(json, request.getResponseType());
    }

    private String createJsonOnError(int code, String message, String errorDescription) {
        if (errorDescription.matches("^\".*\"$")) {
            errorDescription = errorDescription.substring(1, errorDescription.length() - 1);
        }
        return String.format(
                "{\"isOk\": false, \"code\": %d, \"message\": \"%s\", \"errorDescription\": \"%s\"}",
                code, message, errorDescription
        );
    }

    private Request createRequest(BaseRequest<?, ?> request) {
        request.checkRequiredQueries();
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
}
