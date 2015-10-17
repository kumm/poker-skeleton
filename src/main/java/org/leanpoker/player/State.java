package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;

import java.util.List;

/**
 * Created by kumm on 2015.10.17..
 */
public class State {

    private Integer bet;
    private List<Card> holeCards;
    private Integer stack;
    private Integer minimumRaise;
    private Integer myNdx;

    public void update(GameState gameState) {
        myNdx = gameState.getInAction();
        com.wcs.poker.gamestate.Player me = gameState.getPlayers().get(myNdx);
        bet = me.getBet();
        holeCards = me.getHoleCards();
        stack = me.getStack();
        minimumRaise = gameState.getMinimumRaise();
    }

    public Integer getBet() {
        return bet;
    }

    public List<Card> getHoleCards() {
        return holeCards;
    }

    public Integer getStack() {
        return stack;
    }

    public Integer getMinimumRaise() {
        return minimumRaise;
    }

    public boolean amIBlind() {
        return amIBigBlind() || amISmallBlind();
    }

    public boolean amISmallBlind() {
        return myNdx == 0;
    }

    public boolean amIBigBlind() {
        return myNdx == 1;
    }
}
