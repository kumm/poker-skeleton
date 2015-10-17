package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import java.util.List;

/**
 * Created by kumm on 2015.10.17..
 */
public class PreFlopStrategy implements Strategy {

    @Override
    public int betRequest(State gameState) {
        List<Card> holeCards = gameState.getHoleCards();
        int figuras = 0;
        for (Card card : holeCards) {
            if(CardUtility.isFiguras(card)){
                figuras++;
            }
        }
        int betMultiplier = 1;
        if(CardUtility.isSzin(holeCards)){
            betMultiplier+=2;
        }
        if(figuras == 2){
            betMultiplier+=2;
        } else if(figuras == 1){
            betMultiplier+=1;
        }
        return betMultiplier * gameState.getMinimumRaise();
    }
}
