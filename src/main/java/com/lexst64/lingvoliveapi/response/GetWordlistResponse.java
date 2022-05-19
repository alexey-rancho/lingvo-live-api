package com.lexst64.lingvoliveapi.response;

import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.type.WordListItem;

import java.util.Arrays;

public class GetWordlistResponse extends BaseResponse {
    private Lang SourceLanguage;
    private Lang TargetLanguage;
    private boolean InvertedDirection;
    private String Prefix;

    private boolean HasNextPage;

    private String StartPos;
    private WordListItem[] Headings;
    public Lang sourceLanguage() {
        return SourceLanguage;
    }

    public Lang targetLanguage() {
        return TargetLanguage;
    }

    public boolean invertedDirection() {
        return InvertedDirection;
    }

    public String prefix() {
        return Prefix;
    }

    public boolean hasNextPage() {
        return HasNextPage;
    }

    public String startPos() {
        return StartPos;
    }

    public WordListItem[] headings() {
        return Headings;
    }

    @Override
    public String toString() {
        return "GetWordlistResponse{" +
                "SourceLanguage=" + SourceLanguage +
                ", TargetLanguage=" + TargetLanguage +
                ", InvertedDirection=" + InvertedDirection +
                ", Prefix='" + Prefix + '\'' +
                ", HasNextPage=" + HasNextPage +
                ", StartPos='" + StartPos + '\'' +
                ", Headings=" + Arrays.toString(Headings) +
                ", isOk=" + isOk +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
