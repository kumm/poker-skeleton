package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumm on 2015.10.17..
 */
public class State {

    private Integer bet;
    private List<Card> cards;
    private Integer stack;
    private Integer minimumRaise;
    private int myNdx;
    private int dealerNdx;
    private int smallBlindNdx;
    private List<Player> players;
    private int bigBlindNdx;
    private int currentBuyIn;
    private int pot;

    public void update(GameState gameState) {
        myNdx = gameState.getInAction();
        com.wcs.poker.gamestate.Player me = gameState.getPlayers().get(myNdx);
        bet = me.getBet();
        cards = new ArrayList<>();
        cards.addAll(me.getHoleCards());
        cards.addAll(gameState.getCommunityCards());
        stack = me.getStack();
        minimumRaise = gameState.getMinimumRaise();
        dealerNdx = gameState.getDealer();
        smallBlindNdx = gameState.getSmallBlind();
        currentBuyIn = gameState.getCurrentBuyIn();
        pot = gameState.getPot();
        bigBlindNdx = smallBlindNdx + 1;
        players = gameState.getPlayers();
        bigBlindNdx = bigBlindNdx >= players.size() ? 0 : bigBlindNdx;
    }

    public int getBet() {
        return bet;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getStack() {
        return stack;
    }

    public int getMinimumRaise() {
        return minimumRaise;
    }

    public boolean amIBlind() {
        return amIBigBlind() || amISmallBlind();
    }

    public boolean amISmallBlind() {
        return myNdx == smallBlindNdx;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }


    public int getPot() {
        return pot;
    }

    public boolean amIBigBlind() {
        return bigBlindNdx == myNdx;
    }
}
