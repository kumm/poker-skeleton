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
        if(figuras == 2){
            return 4*gameState.getMinimumRaise();
        } else if(figuras == 1){
           return  2*gameState.getMinimumRaise();
        }
        return gameState.getMinimumRaise();
    }
}
