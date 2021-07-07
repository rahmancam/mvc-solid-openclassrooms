package com.rahman.oc.cardgame.model;

import java.util.ArrayList;

public class NormalDeck extends Deck {
    public NormalDeck() {
        cards = new ArrayList<PlayingCard>();
        for (Rank rank: Rank.values()) {
            for(Suite suit: Suite.values()) {
                System.out.println("Creating card : ["+ rank + "][" + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }

        shuffle();
    }
}
