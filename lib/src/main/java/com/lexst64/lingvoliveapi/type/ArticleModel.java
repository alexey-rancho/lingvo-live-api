package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ArticleModel {
    @SerializedName("Title")
    private String title;

    @SerializedName("TitleMarkup")
    private ArticleNode[] titleMarkup;

    @SerializedName("Dictionary")
    private String dictionary;

    @SerializedName("ArticleId")
    private String articleId;

    @SerializedName("Body")
    private ArticleNode[] body;

    public String getTitle() {
        return title;
    }

    public ArticleNode[] getTitleMarkup() {
        return titleMarkup;
    }

    public String getDictionary() {
        return dictionary;
    }

    public String getArticleId() {
        return articleId;
    }

    public ArticleNode[] getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "title='" + title + '\'' +
                ", titleMarkup=" + Arrays.toString(titleMarkup) +
                ", dictionary='" + dictionary + '\'' +
                ", articleId='" + articleId + '\'' +
                ", body=" + Arrays.toString(body) +
                '}';
    }
}
