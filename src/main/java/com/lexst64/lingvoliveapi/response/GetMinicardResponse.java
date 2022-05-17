package com.lexst64.lingvoliveapi.response;

import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.type.WordListItem;

import java.util.Arrays;

public class GetMinicardResponse extends BaseResponse {

    private Lang SourceLanguage;
    private Lang TargetLanguage;
    private String Heading;
    private WordListItem Translation;
    private String[] SeeAlso;

    public Lang sourceLanguage() {
        return SourceLanguage;
    }

    public Lang targetLanguage() {
        return TargetLanguage;
    }

    public String heading() {
        return Heading;
    }

    public WordListItem translation() {
        return Translation;
    }

    public String[] seeAlso() {
        return SeeAlso;
    }

    @Override
    public String toString() {
        return "GetMinicardResponse{" +
                "SourceLanguage=" + SourceLanguage +
                ", TargetLanguage=" + TargetLanguage +
                ", Heading='" + Heading + '\'' +
                ", Translation=" + Translation +
                ", SeeAlso=" + Arrays.toString(SeeAlso) +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
