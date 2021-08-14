package com.example.motivationalquotesapp.util;
import com.loopj.android.http.*;

public class QuotesRestClient {

    private static final String QUOTES_API_URL = "https://api.quotable.io/random";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get( RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get( QUOTES_API_URL,params, responseHandler);
    }

}
