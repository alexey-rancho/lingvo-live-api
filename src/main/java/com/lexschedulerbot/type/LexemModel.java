package com.lexschedulerbot.type;

import com.google.gson.annotations.SerializedName;

public class LexemModel {
    @SerializedName("Lexem")
    private String lexem;

    @SerializedName("PartOfSpeech")
    private String partOfSpeech;

    @SerializedName("ParadigmJson")
    private ParadigmModel paradigmJson;

    public String getLexem() {
        return lexem;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public ParadigmModel getParadigmJson() {
        return paradigmJson;
    }

    @Override
    public String toString() {
        return "LexemModel{" +
                "lexem='" + lexem + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                ", paradigmJson=" + paradigmJson +
                '}';
    }
}
