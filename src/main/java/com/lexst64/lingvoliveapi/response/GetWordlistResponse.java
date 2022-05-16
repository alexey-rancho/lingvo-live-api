package com.lexst64.lingvoliveapi.response;

import com.google.gson.annotations.SerializedName;
import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.type.WordListItem;

import java.util.Arrays;

public class GetWordlistResponse extends BaseResponse {
    @SerializedName("SourceLanguage")
    private Lang sourceLanguage;

    @SerializedName("TargetLanguage")
    private Lang targetLanguage;

    @SerializedName("InvertedDirection")
    private boolean invertedDirection;

    @SerializedName("Prefix")
    private String prefix;

    @SerializedName("HasNextPage")
    private boolean hasNextPage;

    @SerializedName("StartPos")
    private String startPos;

    @SerializedName("Headings")
    private WordListItem[] headings;

    public Lang getSourceLanguage() {
        return sourceLanguage;
    }

    public Lang getTargetLanguage() {
        return targetLanguage;
    }

    public boolean isInvertedDirection() {
        return invertedDirection;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public String getStartPos() {
        return startPos;
    }

    public WordListItem[] getHeadings() {
        return headings;
    }

    @Override
    public String toString() {
        return "GetWordlistResponse{" +
                "sourceLanguage=" + sourceLanguage +
                ", targetLanguage=" + targetLanguage +
                ", invertedDirection=" + invertedDirection +
                ", prefix='" + prefix + '\'' +
                ", hasNextPage=" + hasNextPage +
                ", startPos='" + startPos + '\'' +
                ", headings=" + Arrays.toString(headings) +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
