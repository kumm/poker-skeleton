package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "2:kamikaze";
    private static State STATE;


    synchronized public static int betRequest(GameState gameState) {
        Strategy strategy = findStrategy(gameState);
        State state = getStateInstance(gameState);
        return strategy.betRequest(state);
    }


    private static State getStateInstance(GameState gameState) {
        if (STATE == null) {
            STATE = new State();
        }
        STATE.update(gameState);
        return STATE;
    }


    private static Strategy findStrategy(GameState gameState) {
        int commCards = gameState.getCommunityCards().size();
        switch (commCards) {
            case 0:
                return new PreFlopStrategy();
            default:
                return new FlopStrategy();
        }
    }


    synchronized public static void showdown(GameState gameState) {
        STATE = null;
    }
}
