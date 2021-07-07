package com.rahman.oc.cardgame.view;

import com.rahman.oc.cardgame.controller.GameController;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameViewables implements  GameViewable {
    Vector<GameViewable> views;


    public GameViewables() {
        this.views = new Vector<GameViewable>();
    }

    public  void  addViewable(GameViewable gameViewable){
        views.add(gameViewable);
    }

    @Override
    public void setController(GameController gc) {
        for (GameViewable gameViewable : views){
            gameViewable.setController(gc);
        }

    }

    @Override
    public void promptForNewGame() {
        for (GameViewable gameViewable : views){
            gameViewable.promptForNewGame();
        }
    }

    @Override
    public void promptForFlip() {
        for (GameViewable gameViewable : views){
            gameViewable.promptForFlip();
        }
    }

    @Override
    public void promptForPlayerName() {
        for (GameViewable gameViewable : views){
            gameViewable.promptForPlayerName();
        }
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
        for (GameViewable gameViewable : views){
            gameViewable.showFaceDownCardForPlayer(playerIndex, playerName );
        }
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        for (GameViewable gameViewable : views){
            gameViewable.showPlayerName(playerIndex, playerName );
        }
    }

    @Override
    public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit) {
        for (GameViewable gameViewable : views){
            gameViewable.showCardForPlayer(playerIndex, playerName,  rank, suit );
        }
    }

    @Override
    public void showWinner(String winner) {
        for (GameViewable gameViewable : views) {
            gameViewable.showWinner(winner);

        }
    }
}
