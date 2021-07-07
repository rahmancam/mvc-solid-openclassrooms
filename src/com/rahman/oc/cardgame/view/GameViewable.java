package com.rahman.oc.cardgame.view;

import com.rahman.oc.cardgame.controller.GameController;

public interface GameViewable {
    public void setController(GameController gc);
    public void promptForPlayerName();
    public void promptForFlip();
    public void promptForNewGame();
    public void showPlayerName(int playerIndex, String playerName);
    public void showFaceDownCardForPlayer(int playerIndex, String playerName);
    public void showCardForPlayer(int playerIndex, String playerName, String rank, String suit);
    public void showWinner(String winnerName);
}
