package com.example.motivationalquotesapp.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class WikiRestClient {

    private static final String WIKI_API_URL = "https://en.wikipedia.org/api/rest_v1/page/summary/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String title,RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get( WIKI_API_URL+title,params, responseHandler);
    }
}
