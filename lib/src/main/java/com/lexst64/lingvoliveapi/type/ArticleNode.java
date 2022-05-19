package com.lexst64.lingvoliveapi.type;

import com.google.gson.annotations.SerializedName;

public class ArticleNode {
    @SerializedName("Node")
    private NodeType node;

    @SerializedName("Text")
    private String text;

    @SerializedName("IsOptional")
    private boolean isOptional;

    public NodeType getNode() {
        return node;
    }

    public String getText() {
        return text;
    }

    public boolean isOptional() {
        return isOptional;
    }

    @Override
    public String toString() {
        return "ArticleNode{" +
                "node=" + node +
                ", text='" + text + '\'' +
                ", isOptional=" + isOptional +
                '}';
    }
}
