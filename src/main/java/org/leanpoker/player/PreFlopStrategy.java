package org.leanpoker.player;

/**
 * Created by kumm on 2015.10.17..
 */
public class PreFlopStrategy implements Strategy {

    @Override
    public int betRequest(State gameState) {
        return 3*gameState.getMinimumRaise();
    }
}
