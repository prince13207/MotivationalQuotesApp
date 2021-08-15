package com.example.motivationalquotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.motivationalquotesapp.databinding.ActivityMainBinding;
import com.example.motivationalquotesapp.databinding.ActivityWikiBinding;
import com.example.motivationalquotesapp.util.WikiRestClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WikiActivity extends AppCompatActivity {
    private ActivityWikiBinding binding;
    public void loadWiki(View view){

        String authorName = getIntent().getStringExtra("AUTHOR_NAME");
        WikiRestClient.get(authorName,null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    System.out.println(response);
                    binding.authorInfoTextView.setText(response.getString("extract"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wiki);
        String authorName = getIntent().getStringExtra("AUTHOR_NAME");
        System.out.println("Author Name: "+authorName);
        binding.authorNameTextView.setText(authorName);
        loadWiki(findViewById(android.R.id.content).getRootView());


    }
}