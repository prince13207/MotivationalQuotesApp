package com.example.motivationalquotesapp;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.motivationalquotesapp.databinding.ActivityMainBinding;
import com.example.motivationalquotesapp.model.Quote;
import com.example.motivationalquotesapp.util.QuotesRestClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    TextToSpeech tts;

    public void readQuote(View view){
        String toSpeak = binding.quoteTextField.getText().toString()+" ; by"+binding.authorNameTextField.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_LONG).show();
        tts.setSpeechRate(0.9f);
        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void onPause(){
        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
    public void reloadQuote(View view){
        TextView quoteText = binding.quoteTextField;
        TextView quoteAuthor = binding.authorNameTextField;
        QuotesRestClient.get(null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    quoteText.setText(response.getString("content"));
                    quoteAuthor.setText(response.getString("author"));

                }
                catch (JSONException ex){
                    ex.printStackTrace();
                }
            }

        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the `activity_main` layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });
        reloadQuote(findViewById(android.R.id.content).getRootView());
        // Attach the user to the binding

    }
}