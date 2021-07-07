package com.rahman.oc.cardgame.model;

public enum Rank {
    NONE(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    public int value() {
        return rank;
    }
}
