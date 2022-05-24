package com.lexst64.lingvoliveapi;

import com.lexst64.lingvoliveapi.lang.LangPair;
import com.lexst64.lingvoliveapi.request.GetMinicard;
import com.lexst64.lingvoliveapi.request.GetWordList;
import com.lexst64.lingvoliveapi.request.GetWordForms;
import com.lexst64.lingvoliveapi.request.GetSuggests;
import com.lexst64.lingvoliveapi.response.GetMinicardResponse;
import com.lexst64.lingvoliveapi.response.GetSuggestsResponse;
import com.lexst64.lingvoliveapi.response.GetWordFormsResponse;
import com.lexst64.lingvoliveapi.response.GetWordListResponse;
import com.lexst64.lingvoliveapi.lang.Lang;
import com.lexst64.lingvoliveapi.type.LexemModel;
import com.lexst64.lingvoliveapi.type.WordListItem;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


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
        GetMinicard request = new GetMinicard("", LangPair.EN_RU);
        GetMinicardResponse response = lingvoLive.execute(request);

        Assertions.assertFalse(response.isOk());
        Assertions.assertEquals(404, response.code());
        Assertions.assertEquals("Not Found", response.message());
        String expectedMessage1 = "No translations found for text \\\"\\\" among available dictionaries";
        Assertions.assertEquals(expectedMessage1, response.errorDescription());
    }

    @Test
    void testGetMinicard() {
        GetMinicard request = new GetMinicard("book", LangPair.EN_RU);
        GetMinicardResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.sourceLanguage());
        Assertions.assertNotNull(response.targetLanguage());
        Assertions.assertNotNull(response.heading());
        Assertions.assertNotNull(response.seeAlso());
        WordListItemTest.check(response.translation());
    }

    @Test
    void testGetSuggestsWhenSuggestsFound() {
        GetSuggests request = new GetSuggests("book", LangPair.EN_RU);
        GetSuggestsResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.suggests());
        for (String suggest : response.suggests()) {
            Assertions.assertNotNull(suggest);
        }
    }

    @Test
    void testGetSuggestsWhenSuggestionsNotFound() {
        GetSuggests request = new GetSuggests("82828jjj", LangPair.EN_RU);
        GetSuggestsResponse response = lingvoLive.execute(request);

        Assertions.assertEquals(404, response.code());
        Assertions.assertNull(response.suggests());
        String expectedMessage = "No suggests found for text \\\"82828jjj\\\" among available dictionaries";
        Assertions.assertEquals(expectedMessage, response.errorDescription());
    }

    @Test
    void testGetWordForms() {
        GetWordForms request = new GetWordForms("book", Lang.EN);
        GetWordFormsResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        for (LexemModel lexemModel : response.lexemModels()) {
            LexemModelTest.check(lexemModel);
        }
    }

    @Test
    void testGetWordlist() {
        GetWordList request = new GetWordList("mother", LangPair.EN_RU, 20);
        request.startPos("mother");

        GetWordListResponse response = lingvoLive.execute(request);
        Assertions.assertEquals(200, response.code());

        Assertions.assertNotNull(response.sourceLanguage());
        Assertions.assertNotNull(response.targetLanguage());
        Assertions.assertNotNull(response.prefix());
        Assertions.assertNotNull(response.startPos());

        for (WordListItem item : response.headings()) {
            WordListItemTest.check(item);
        }
    }

    @Test
    void testAsyncCallbackOnResponse() throws RuntimeException, InterruptedException {
        CountDownLatch lock = new CountDownLatch(1);
        GetMinicard request = new GetMinicard("word", LangPair.EN_RU);

        lingvoLive.execute(request, new Callback<GetMinicard, GetMinicardResponse>() {
            @Override
            public void onResponse(GetMinicard request, GetMinicardResponse response) {
                lock.countDown();
            }

            @Override
            public void onFailure(GetMinicard request, IOException e) {
                throw new RuntimeException(e);
            }
        });
        Assertions.assertTrue(lock.await(5, TimeUnit.SECONDS));
    }

    @Test
    void testAsyncCallbackOnFailure() throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(1);
        LingvoLiveClient client = new LingvoLiveClient(TEST_API_KEY, new OkHttpClient(), null);
        GetMinicard request = new GetMinicard("word", Lang.EN, Lang.RU);
        client.send(request, new Callback<GetMinicard, GetMinicardResponse>() {
            @Override
            public void onResponse(GetMinicard request, GetMinicardResponse response) {

            }

            @Override
            public void onFailure(GetMinicard request, IOException e) {
                lock.countDown();
            }
        });
        Assertions.assertTrue(lock.await(5, TimeUnit.SECONDS));
    }

    @Test
    void testGetApiKey() {
        Assertions.assertEquals(TEST_API_KEY, lingvoLive.getApiKey());
    }
}
