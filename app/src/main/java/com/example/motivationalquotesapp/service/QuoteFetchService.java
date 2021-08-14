package com.example.motivationalquotesapp.service;

import com.example.motivationalquotesapp.model.Quote;
import com.example.motivationalquotesapp.util.QuotesRestClient;
import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class QuoteFetchService {

    public static Quote  getRandomQuote() throws JSONException{
        final Quote[] q = new Quote[1];
        QuotesRestClient.get(null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    System.out.println("Read Quote from API :" + response.toString());
                    q[0] = new Quote(response.getString("content"), response.getString("author"));
                    System.out.println("Read Quote from API :" + q[0]);
                }
                catch (JSONException ex){
                    ex.printStackTrace();
                }
            }

        });

    return q[0];
    }

}
