package com.rahman.oc.cardgame.games;

import com.rahman.oc.cardgame.model.Player;
import com.rahman.oc.cardgame.model.PlayingCard;

import java.util.ArrayList;

public interface GameEvaluator {
    public Player evaluateWinner(ArrayList<Player> players);
}
