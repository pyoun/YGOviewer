package com.example.peter.ygo_viewer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by Peter on 3/14/2018.
 */

public class getCards {
    private static String DB_PATH =
            "/data/data/com.example.peter.ygo_viewer/databases/";
    /*Context ctx = this;
    String dbname = "cards_full.db";
    Path DB_PATH = ctx.getDatabasePath(dbname).toPath();*/


    public ArrayList<Card> getCards(String query) {
        String DB_NAME = "cards_full.db";
        SQLiteDatabase cardsDB = SQLiteDatabase.openDatabase(DB_PATH+DB_NAME,
                null, SQLiteDatabase.CREATE_IF_NECESSARY);
        Cursor cardsCursor = cardsDB.rawQuery(query, null);

        int numberIndex = cardsCursor.getColumnIndex("cardNumber");
        int nameIndex = cardsCursor.getColumnIndex("cardName");
        int attrIndex = cardsCursor.getColumnIndex("cardAttribute");
        int typeIndex = cardsCursor.getColumnIndex("cardType");
        int lvlIndex = cardsCursor.getColumnIndex("cardLevel");
        int atkIndex = cardsCursor.getColumnIndex("cardAttack");
        int defIndex = cardsCursor.getColumnIndex("cardDefense");
        int effectIndex = cardsCursor.getColumnIndex("cardEffect");
        int colorIndex = cardsCursor.getColumnIndex("cardColor");

        ArrayList<Card> trunk = new ArrayList<>();
        if (cardsCursor.moveToFirst()) {
            while(!cardsCursor.isAfterLast()) {
                trunk.add(new Card(cardsCursor.getInt(numberIndex),
                        cardsCursor.getString(nameIndex),
                        cardsCursor.getString(attrIndex),
                        cardsCursor.getString(typeIndex),
                        cardsCursor.getInt(lvlIndex),
                        cardsCursor.getDouble(atkIndex),
                        cardsCursor.getDouble(defIndex),
                        cardsCursor.getString(effectIndex),
                        cardsCursor.getString(colorIndex)
                ));
                cardsCursor.moveToNext();
            }
        }
        cardsCursor.close();
        return trunk;
    }
}
