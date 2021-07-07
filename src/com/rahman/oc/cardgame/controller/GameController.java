package com.rahman.oc.cardgame.controller;

import com.rahman.oc.cardgame.games.GameEvaluator;
import com.rahman.oc.cardgame.model.*;
import com.rahman.oc.cardgame.view.GameViewable;
import com.rahman.oc.cardgame.view.GameViewables;

import java.util.ArrayList;


public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed,
        AddingView
    }

    Deck deck;
    ArrayList<IPlayer> players;
    IPlayer winner;
    GameViewables views;
    GameState gameState;
    GameEvaluator evaluator;

    public GameController(GameViewable view, Deck deck, GameEvaluator gameEvaluator) {
        this.deck = deck;
        this.views = new GameViewables();
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        evaluator = gameEvaluator;
        addViewable(view);
    }

    public void addViewable(GameViewable newView) {
        GameState curState = gameState;
        gameState = GameState.AddingView;
        newView.setController(this);
        views.addViewable(newView);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gameState = curState;
    }

    public void  run (){
        while (true){
            switch ( gameState){
                case AddingPlayers:
                    views.promptForPlayerName();
                    break;
                case CardsDealt:
                    views.promptForFlip();
                    break;
                case WinnerRevealed:
                    views.promptForNewGame();
                    break;
                case AddingView:
                    break;
            }
        }
    }

    public  void  addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            views.showPlayerName(players.size(), playerName);
        }
    }

    public  void  startGame(){
        if(gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player : players){
                player.addCardToHand(deck.removeTopCard());
                views.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }

    public  void flipCards(){
        int playerIndex = 1;
        for (IPlayer player : players){
            PlayingCard pc = player.getCard(0);
            pc.flip(true);
            views.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuite().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
    }

    private void rebuildDeck() {
        for(IPlayer player: players) {
            deck.returnCard(player.removeCard());
        }
    }

    private void displayWinner() {
        views.showWinner(winner.getName());

    }

    public void restartGame() {
        rebuildDeck();
        gameState = GameState.AddingPlayers;
    }

    private void evaluateWinner() {
        winner = new WinningPlayer(evaluator.evaluateWinner(players));
    }
}
