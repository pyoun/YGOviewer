package com.example.peter.ygo_viewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import java.util.ArrayList;

/**
 * Created by Peter on 3/14/2018.
 */

public class DisplayCard extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_details);
        String cardNumber = this.getIntent().getExtras().getString("number");
        getCards helper = new getCards();
        ArrayList<Card> selectedCard = helper.getCards(
                "SELECT * FROM 'cards_full' WHERE cardNumber = " + cardNumber);

        //WebView
        /*String name = selectedCard.get(0).cardName;
        setTitle(name);
        mWebView = findViewById(R.id.detail_card_view);
        mWebView.loadUrl("http://yugioh.wikia.com/wiki/"+name);*/
    }
}
