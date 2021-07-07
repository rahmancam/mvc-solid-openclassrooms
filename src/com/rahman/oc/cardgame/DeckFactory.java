package com.rahman.oc.cardgame;

import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.model.NormalDeck;
import com.rahman.oc.cardgame.model.SmallDeck;

public class DeckFactory {
    public  enum  DeckType{
        NORMAL,
        SMALL
    }

    public static Deck makeDeck(DeckType deckType){
        switch (deckType){
            case NORMAL: return new NormalDeck();
            case SMALL: return new SmallDeck();
        }

        return new NormalDeck();

    }
}
