package com.lexst64.lingvoliveapi.type;

public class LexemModel {

    private String Lexem;
    private String PartOfSpeech;
    private ParadigmModel ParadigmJson;

    public String lexem() {
        return Lexem;
    }

    public String partOfSpeech() {
        return PartOfSpeech;
    }

    public ParadigmModel paradigmJson() {
        return ParadigmJson;
    }

    @Override
    public String toString() {
        return "LexemModel{" +
                "lexem='" + Lexem + '\'' +
                ", partOfSpeech='" + PartOfSpeech + '\'' +
                ", paradigmJson=" + ParadigmJson +
                '}';
    }
}
