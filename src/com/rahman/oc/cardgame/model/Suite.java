package com.rahman.oc.cardgame.model;

public enum Suite {
    DIAMONDS (1),
    HEARTS(2),
    SPADES(3),
    CLUBS(4);

    int suite;

    Suite(int suite) {
        this.suite = suite;
    }

    public int value() {
        return suite;
    }
}
