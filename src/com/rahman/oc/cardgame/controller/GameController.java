package com.rahman.oc.cardgame.controller;

import com.rahman.oc.cardgame.games.GameEvaluator;
import com.rahman.oc.cardgame.model.Deck;
import com.rahman.oc.cardgame.model.Player;
import com.rahman.oc.cardgame.model.PlayingCard;
import com.rahman.oc.cardgame.view.ConsoleView;
import com.rahman.oc.cardgame.view.GameViewable;
import com.rahman.oc.cardgame.view.GameViewables;

import java.util.ArrayList;


public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed;
    }

    Deck deck;
    ArrayList<Player> players;
    Player winner;
    GameViewables view;
    GameState gameState;
    GameEvaluator evaluator;

    public GameController(GameViewables view, Deck deck, GameEvaluator gameEvaluator) {
        this.deck = deck;
        this.view = view;
        players = new ArrayList<>();
        gameState = GameState.AddingPlayers;
        evaluator = gameEvaluator;
        view.setController(this);
    }

    public void  run (){
        while (true){
            switch ( gameState){
                case AddingPlayers:
                    view.promptForPlayerName();
                    break;
                case CardsDealt:
                    view.promptForFlip();
                    break;
                case WinnerRevealed:
                    view.promptForNewGame();
                    break;
            }
        }
    }

    public  void  addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            players.add(new Player(playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }

    public  void  startGame(){
        if(gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
    }

    public  void flipCards(){
        int playerIndex = 1;
        for (Player player : players){
            PlayingCard pc = player.getCard(0);
            pc.flip(true);
            view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuite().toString());
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
        view.showWinner(winner.getName());

    }

    public void restartGame() {
        rebuildDeck();
        gameState = GameState.AddingPlayers;
    }

    private void evaluateWinner() {
        winner = evaluator.evaluateWinner(players);
    }
}
