package com.rahman.oc.cardgame.model;

import java.util.*;

public  class Deck {
    ArrayList<PlayingCard> cards;

    public Deck() {
        cards = new ArrayList<PlayingCard>();
        for (Rank rank: Rank.values()) {
            for(Suite suit: Suite.values()) {
                System.out.println("Creating card : ["+ rank + "][" + suit + "]");
                cards.add(new PlayingCard(rank, suit));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Random random = new Random();
        for (int i= 0; i < cards.size(); i++){
            Collections.swap( cards, i, random.nextInt(cards.size()));
        }
    }

    public  PlayingCard removeTopCard(){
        return  cards.remove(0);
    }

    public void returnCard(PlayingCard pc){
        cards.add(pc);
    }
}
