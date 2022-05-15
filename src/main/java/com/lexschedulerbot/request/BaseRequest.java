package com.lexschedulerbot.request;

import com.lexschedulerbot.response.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;

abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;

    private final Class<? extends R> responseClass;
    private final Map<String, Object> queries;

    public BaseRequest(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        queries = new LinkedHashMap<>();
    }

    protected T addQuery(String name, Object value) {
        queries.put(name, value);
        return thisAsT;
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
