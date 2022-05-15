package com.lexschedulerbot.response;

import com.google.gson.annotations.SerializedName;
import com.lexschedulerbot.type.WordListItem;

import java.util.Arrays;

public class GetMinicardResponse extends BaseResponse {

    @SerializedName("SourceLanguage")
    private int sourceLanguage;
    @SerializedName("TargetLanguage")
    private int targetLanguage;
    @SerializedName("Heading")
    private String heading;
    @SerializedName("Translation")
    private WordListItem translation;
    @SerializedName("SeeAlso")
    private String[] seeAlso;

    @Override
    public String toString() {
        return "GetMinicardResponse{" +
                "sourceLanguage=" + sourceLanguage +
                ", targetLanguage=" + targetLanguage +
                ", heading='" + heading + '\'' +
                ", translation=" + translation +
                ", seeAlso=" + Arrays.toString(seeAlso) +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
