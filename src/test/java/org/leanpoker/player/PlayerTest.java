package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testBetRequest() throws Exception {
        final GameState gameState = new GameState();
        gameState.setMinimumRaise(10);

        assertEquals(gameState.getMinimumRaise().intValue(), Player.betRequest(gameState));
    }
}
