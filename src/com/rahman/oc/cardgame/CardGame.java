package com.rahman.oc.cardgame;

import com.rahman.oc.cardgame.controller.GameController;
import com.rahman.oc.cardgame.games.HighCardGameEvaulator;
import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.view.ConsoleView;

public class CardGame {

    GameController controller;
    public CardGame() {
        this.controller = new GameController(new ConsoleView(), new Deck(), new HighCardGameEvaulator());
    }

    public void run() {
        controller.run();
    }
}
