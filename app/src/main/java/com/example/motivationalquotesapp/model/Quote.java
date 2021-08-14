package com.example.motivationalquotesapp.model;

public class Quote {

    private String quoteMessage;
    private String quoteAuthor;
    public Quote(){

    }
    public Quote(String quoteMessage, String quoteAuthor) {
        this.quoteMessage = quoteMessage;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteMessage() {
        return quoteMessage;
    }

    public void setQuoteMessage(String quoteMessage) {
        this.quoteMessage = quoteMessage;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteMessage='" + quoteMessage + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
