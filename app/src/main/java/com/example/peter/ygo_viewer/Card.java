package com.example.peter.ygo_viewer;

/**
 * Created by Peter on 3/11/2018.
 */

public class Card {
    public int cardNumber = 0;
    public String cardName = "";
    public String cardAttribute = "";
    public String cardType = "";
    public int cardLevel = 0;
    public double cardAttack = 0.0;
    public double cardDefense = 0.0;
    public String cardEffect = "";
    public String cardColor = "";

    public Card(int cardNumber, String cardName, String cardAttribute,
                String cardType, int cardLevel, double cardAttack,
                double cardDefense, String cardEffect, String cardColor) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardAttribute = cardAttribute;
        this.cardType = cardType;
        this.cardLevel = cardLevel;
        this.cardAttack = cardAttack;
        this.cardDefense = cardDefense;
        this.cardEffect = cardEffect;
        this.cardColor = cardColor;
    }

}
