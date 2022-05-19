package com.lexst64.lingvoliveapi.response;

import com.google.gson.annotations.SerializedName;
import com.lexst64.lingvoliveapi.type.ArticleModel;

import java.util.Arrays;

/**
 * @deprecated {@link GetSearchResponse} doesn't meet the json structure
 * that api method Search returns on request
 * */
@Deprecated
public class GetSearchResponse extends BaseResponse {
    @SerializedName("Items")
    private ArticleModel[] items;

    @SerializedName("TotalCount")
    private int totalCount;

    @SerializedName("HasNextPage")
    private boolean hasNextPage;

    public ArticleModel[] getItems() {
        return items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public boolean hasNextPage() {
        return hasNextPage;
    }

    @Override
    public String toString() {
        return "GetSearchResponse{" +
                "items=" + Arrays.toString(items) +
                ", totalCount=" + totalCount +
                ", hasNextPage=" + hasNextPage +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
