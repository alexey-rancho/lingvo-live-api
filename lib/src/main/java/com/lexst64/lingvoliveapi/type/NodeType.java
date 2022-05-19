package com.lexst64.lingvoliveapi.type;

public enum NodeType {
    COMMENT(0),
    PARAGRAPH(1),
    TEXT(2),
    LIST(3),
    LIST_ITEM(4),
    EXAMPLES(5),
    EXAMPLE_ITEM(6),
    EXAMPLE(7),
    CARD_REFS(8),
    CARD_REF_ITEM(9),
    CARD_REF(10),
    TRANSCRIPTION(11),
    ABBREV(12),
    CAPTION(13),
    SOUND(14),
    REF(15),
    UNSUPPORTED(16);

    private final int code;

    NodeType(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
