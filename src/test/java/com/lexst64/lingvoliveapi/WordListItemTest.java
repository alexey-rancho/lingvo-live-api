package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.type.WordListItem;
import org.junit.jupiter.api.Assertions;

public class WordListItemTest {
    public static void check(WordListItem wordListItem) {
        Assertions.assertNotNull(wordListItem.heading());
        Assertions.assertNotNull(wordListItem.translation());
        Assertions.assertNotNull(wordListItem.dictionaryName());
        Assertions.assertNotNull(wordListItem.soundName());
        Assertions.assertNotNull(wordListItem.type());
        Assertions.assertNotNull(wordListItem.originalWord());
    }
}
