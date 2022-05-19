package com.lexst64.lingvoliveapi.request;

import com.lexst64.lingvoliveapi.MissingQueryException;
import com.lexst64.lingvoliveapi.response.BaseResponse;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

abstract public class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;

    private final Class<? extends R> responseClass;
    private final Map<String, Object> queries;
    private final List<String> requiredQueries;

    public BaseRequest(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        queries = new LinkedHashMap<>();
        requiredQueries = new ArrayList<>();
    }

    /**
     * Checks if all the required queries has been set
     * @throws MissingQueryException if required query hasn't been set for
     * the current {@link BaseRequest} descendant
     * */
    public void checkRequiredQueries() throws MissingQueryException {
        for (String query : requiredQueries) {
            if (!queries.containsKey(query)) {
                throw new MissingQueryException(this.getClass().getSimpleName(), query);
            }
        }
    }

    protected void setRequiredQueries(String... queries) {
        requiredQueries.addAll(Arrays.asList(queries));
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
