package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.response.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;

abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    private final Class<? extends R> responseClass;
    private final Map<String, Object> queries;

    public BaseRequest(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        queries = new LinkedHashMap<>();
    }

    protected void addQuery(String name, Object value) {
        queries.put(name, value);
    }

    public Map<String, Object> getQueries() {
        return queries;
    }

    public String getMethod() {
        String className = this.getClass().getSimpleName();
        return className.substring(3);
    }

    public Class<? extends R> getResponseType() {
        return responseClass;
    }
}
