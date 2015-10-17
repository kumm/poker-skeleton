package org.leanpoker.player;

import com.wcs.poker.gamestate.Rank;
import java.util.Map;

/**
 * Created by kumm on 2015.10.17..
 */
public class FlopStrategy implements Strategy {

    @Override
    public int betRequest(State state) {
        int call = state.getCurrentBuyIn() - state.getBet();
        Map<Rank, Integer> ranks = CardUtility.getRanks(state.getCards());
        int par = CardUtility.getPar(ranks);
        if(CardUtility.hasPoker(ranks) || CardUtility.hasSzin(state.getCards())){
            return Integer.MAX_VALUE;
        }
        if(CardUtility.hasSzin(state.getCards())){
            return call + state.getMinimumRaise() * 10;
        }
        if(CardUtility.hasDrill(ranks)){
            return call + state.getMinimumRaise() * 4;
        }
        if (par == 1) {
            if (state.getBet() > state.getStack() / 2) {
                return 0;
            }
            return call;
        } else if (par == 2) {
            return call + state.getMinimumRaise() * 3;
        }
        // TODO átgondolni!!!
        if (state.getCards().size() == 7) {
            return 0;
        }
        return call;
    }
}
