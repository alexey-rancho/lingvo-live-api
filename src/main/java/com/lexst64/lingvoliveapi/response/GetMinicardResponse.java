package com.lexst64.lingvoliveapi.response;

import com.google.gson.annotations.SerializedName;
import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.type.WordListItem;

import java.util.Arrays;

public class GetMinicardResponse extends BaseResponse {

    @SerializedName("SourceLanguage")
    private Lang sourceLanguage;
    @SerializedName("TargetLanguage")
    private Lang targetLanguage;
    @SerializedName("Heading")
    private String heading;
    @SerializedName("Translation")
    private WordListItem translation;
    @SerializedName("SeeAlso")
    private String[] seeAlso;

    public Lang getSourceLanguage() {
        return sourceLanguage;
    }

    public Lang getTargetLanguage() {
        return targetLanguage;
    }

    public String getHeading() {
        return heading;
    }

    public WordListItem getTranslation() {
        return translation;
    }

    public String[] getSeeAlso() {
        return seeAlso;
    }

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
