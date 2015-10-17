package org.leanpoker.player;

/**
 * Created by kumm on 2015.10.17..
 */
public interface Strategy {
    int betRequest(State gameState);
}
