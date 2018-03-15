package com.example.peter.ygo_viewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Peter on 3/11/2018.
 */

public class DisplayTrunk extends AppCompatActivity {
    private static String DB_PATH =
            "/data/data/com.example.peter.ygo_viewer/databases/";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_trunk);

        mListView = findViewById(R.id.Trunk);
        getCards helper = new getCards();
        final ArrayList<Card> cardList = helper.getCards(
                "SELECT * FROM 'cards_full'");
        String[] listItems = new String[cardList.size()];
        for (int i = 0; i < cardList.size(); i++) {
            Card card = cardList.get(i);
            listItems[i] = card.cardName;
        }

        TrunkAdapter adapter = new TrunkAdapter(this, cardList);
        mListView.setAdapter(adapter);

        //----------onClick
        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Card selectedCard = cardList.get(position);
                Intent detailIntent = new Intent(context, DisplayCard.class);
                detailIntent.putExtra("number", Integer.toString(selectedCard.cardNumber));
                startActivity(detailIntent);
            }
        });
    }
}
