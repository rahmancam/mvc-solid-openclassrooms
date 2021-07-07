package com.rahman.oc.cardgame.games;

import com.rahman.oc.cardgame.model.IPlayer;
import com.rahman.oc.cardgame.model.PlayingCard;

import java.util.ArrayList;

public class HighCardGameEvaulator implements GameEvaluator {
    public IPlayer evaluateWinner(ArrayList<IPlayer> players) {
        IPlayer bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for( IPlayer player: players) {
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

        return bestPlayer;
    }
}
