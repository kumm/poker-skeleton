package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "1:kamikaze";

    public static int betRequest(GameState gameState) {
//        Integer myNdx = gameState.getInAction();
//        com.wcs.poker.gamestate.Player me = gameState.getPlayers().get(myNdx);
        
        return gameState.getMinimumRaise();
    }


    public static void showdown(GameState gameState) {
    }
}
