package com.rahman.oc.cardgame.model;

public class PlayingCard {
    Rank rank;
    Suite suite;
    boolean faceup;

    public PlayingCard(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
        faceup = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Suite getSuite() {
        return suite;
    }

    public boolean isFaceup() {
        return faceup;
    }

    public void flip(boolean faceup) {
        this.faceup = faceup;
    }
}
