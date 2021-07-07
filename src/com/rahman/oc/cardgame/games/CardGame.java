package com.rahman.oc.cardgame.games;

import com.rahman.oc.cardgame.controller.GameController;
import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.view.View;

public class CardGame {

    GameController controller;
    public CardGame() {
        this.controller = new GameController(new View(), new Deck());
    }

    public void run() {
        controller.run();
    }
}
