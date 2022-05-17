package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.request.*;
import com.lexst64.lingvoliveapi.response.*;
import com.lexst64.lingvoliveapi.type.Lang;
import com.lexst64.lingvoliveapi.type.LexemModel;
import com.lexst64.lingvoliveapi.type.WordListItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class LingvoLiveTest {

    static final String TEST_API_KEY = System.getenv("TEST_API_KEY");
    static final LingvoLive lingvoLive = new LingvoLive(TEST_API_KEY);

    @Test
    void testAuthenticate() {
        Assertions.assertThrowsExactly(AuthenticationException.class, () -> new LingvoLive(""));
        Assertions.assertThrowsExactly(AuthenticationException.class, () -> new LingvoLive("AwdaAWDawaAd"));
        Assertions.assertThrowsExactly(AuthenticationException.class, () -> new LingvoLive(null));
        Assertions.assertInstanceOf(LingvoLive.class, new LingvoLive(TEST_API_KEY));
    }

    @Test
    void testExecuteWhenTranslationNotFound() {
        GetMinicard request = new GetMinicard().srcLang(Lang.ENGLISH).dstLang(Lang.RUSSIAN).text("");
        GetMinicardResponse response = lingvoLive.execute(request);

        Assertions.assertFalse(response.isOk());
        Assertions.assertEquals(404, response.code());
        Assertions.assertEquals("Not Found", response.message());
        String expectedMessage1 = "No translations found for text \\\"\\\" among available dictionaries";
        Assertions.assertEquals(expectedMessage1, response.errorDescription());
    }

    @Test
    void testGetMinicard() {
        GetMinicard request = new GetMinicard().srcLang(Lang.ENGLISH).dstLang(Lang.RUSSIAN).text("book");
        GetMinicardResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.sourceLanguage());
        Assertions.assertNotNull(response.targetLanguage());
        Assertions.assertNotNull(response.heading());
        Assertions.assertNotNull(response.seeAlso());
        WordListItemTest.check(response.translation());
    }

    @Test
    void testGetSuggests() {
        GetSuggests request = new GetSuggests().srcLang(Lang.ENGLISH).dstLang(Lang.RUSSIAN).text("book");
        GetSuggestsResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.suggests());
        for (String suggest : response.suggests()) {
            Assertions.assertNotNull(suggest);
        }
    }

    @Test
    void testGetWordForms() {
        GetWordForms request = new GetWordForms().lang(Lang.ENGLISH).text("book");
        GetWordFormsResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        for (LexemModel lexemModel : response.lexemModels()) {
            LexemModelTest.check(lexemModel);
        }
    }

    @Test
    void testGetWordlist() {
        GetWordlist request = new GetWordlist()
                .srcLang(Lang.ENGLISH)
                .dstLang(Lang.RUSSIAN)
                .prefix("mother")
                .pageSize(20)
                .startPos("mother");
        GetWordlistResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.sourceLanguage());
        Assertions.assertNotNull(response.targetLanguage());
        Assertions.assertNotNull(response.prefix());
        Assertions.assertNotNull(response.startPos());

        for (WordListItem item : response.headings()) {
            WordListItemTest.check(item);
        }
    }
}
