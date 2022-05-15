package com.lexschedulerbot.request;

import com.lexschedulerbot.response.BaseResponse;
import okhttp3.Headers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;

    private final Class<? extends R> responseClass;
    private final String httpMethod;
    private final String apiMethod;
    private final Map<String, String> headers;
    private final Map<String, Object> queries;

    public BaseRequest(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        String[] httpAndApiMethods = splitClassName(this.getClass().getSimpleName());
        this.httpMethod = httpAndApiMethods[0];
        this.apiMethod = httpAndApiMethods[1];
        queries = new LinkedHashMap<>();
        headers = new LinkedHashMap<>();
    }

    protected T addQuery(String name, Object value) {
        queries.put(name, value);
        return thisAsT;
    }

    protected T addHeader(String name, String value) {
        headers.put(name, value);
        return thisAsT;
    }

    public boolean containsBearerHeader() {
        return headers.containsKey("Authorization") && headers.get("Authorization").startsWith("Bearer");
    }

    public void addBearerHeader(String bearerToken) {
        addHeader("Authorization", "Bearer " + bearerToken);
    }

    protected void addBasicHeader(String apiKey) {
        addHeader("Authorization", "Basic " + apiKey);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, Object> getQueries() {
        return queries;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public Class<? extends R> getResponseType() {
        return responseClass;
    }

    private String[] splitCamelCase(String s) {
        return s.split(String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"
        ));
    }

    private String[] splitClassName(String className) {
        String[] methods = new String[2];
        String[] words = splitCamelCase(className);
        if (words.length < 2) {
            throw new RuntimeException("Incorrect class name");
        }
        methods[0] = words[0];
        methods[1] = String.join("", Arrays.copyOfRange(words, 1, words.length));
        return methods;
    }
}
