package com.rahman.oc.cardgame.games;

import com.rahman.oc.cardgame.model.IPlayer;

import java.util.ArrayList;

public interface GameEvaluator {
    public IPlayer evaluateWinner(ArrayList<IPlayer> players);
}
