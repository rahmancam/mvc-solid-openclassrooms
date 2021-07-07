package com.rahman.oc.cardgame;

import com.rahman.oc.cardgame.controller.GameController;
import com.rahman.oc.cardgame.games.GameEvaluator;
import com.rahman.oc.cardgame.games.HighCardGameEvaulator;
import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.view.ConsoleView;
import com.rahman.oc.cardgame.view.GameViewable;
import com.rahman.oc.cardgame.view.SwingView;

public class CardGame {

    GameController controller;
    public CardGame() {
        // ConsoleView consoleView = new ConsoleView();
        SwingView swingView = new SwingView();
        Deck deck = DeckFactory.makeDeck(DeckFactory.DeckType.NORMAL);
        GameEvaluator evaluator = new HighCardGameEvaulator();
        this.controller = new GameController(swingView, deck, evaluator);
        swingView.createAndShowGUI();
    }

    public void run() {
        controller.run();
    }
}
