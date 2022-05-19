package com.lexst64.lingvoliveapi.type;

public class WordListItem {
    private String Heading;
    private String Translation;
    private String DictionaryName;
    private String SoundName;
    private WordListItemType Type;
    private String OriginalWord;

    public String heading() {
        return Heading;
    }

    public String translation() {
        return Translation;
    }

    public String dictionaryName() {
        return DictionaryName;
    }

    public String soundName() {
        return SoundName;
    }

    public WordListItemType type() {
        return Type;
    }

    public String originalWord() {
        return OriginalWord;
    }

    @Override
    public String toString() {
        return "WordListItem{" +
                "heading='" + Heading + '\'' +
                ", translation='" + Translation + '\'' +
                ", dictionaryName='" + DictionaryName + '\'' +
                ", soundName='" + SoundName + '\'' +
                ", type=" + Type +
                ", originalWord='" + OriginalWord + '\'' +
                '}';
    }
}
