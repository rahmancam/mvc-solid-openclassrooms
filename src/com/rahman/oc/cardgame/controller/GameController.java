package com.rahman.oc.cardgame.controller;

import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.model.Player;
import com.rahman.oc.cardgame.model.PlayingCard;

import java.util.ArrayList;

class View {
    public void something() {}
    public void setController(GameController gc) {}
}

public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed;
    }

    Deck deck;
    ArrayList<Player> players;
    Player winner;
    View view;
    GameState gameState;

    public GameController(View view, Deck deck) {
        this.deck = deck;
        this.view = view;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    public void  run (){
        while (true){
            switch ( gameState){
                case AddingPlayers:
                    view.something();
                    break;
                case CardsDealt:
                    view.something();
                    break;
                case WinnerRevealed:
                    view.something();
                    break;
            }
        }
    }

    public  void  addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.something();
        }
    }

    public  void  startGame(){
        if(gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
                view.something();
            }
            gameState = GameState.CardsDealt;
        }
    }

    public  void flipCards(){
        int playerIndex = 1;
        for (Player player : players){
            PlayingCard pc = player.getCard(0);
            pc.flip(true);
            view.something();
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
    }

    private void rebuildDeck() {
        for(Player player: players) {
            deck.returnCard(player.removeCard());
        }
    }

    private void displayWinner() {
        view.something();

    }

    private void evaluateWinner() {
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for( Player player: players) {
            boolean newBestPlayer = false;
            if (bestPlayer == null) {
                newBestPlayer = true;
            } else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                if( thisRank >= bestRank) {
                    if(thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if(pc.getSuite().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if(newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuite().value();
            }
        }

        winner = bestPlayer;
    }
}
