/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;

/**
 *
 * @author peter
 */
public class CardUtility {
    public static boolean isFiguras(Card card){
        return card.getRank() == Rank.JACK
                || card.getRank() == Rank.QUEEN
                || card.getRank() == Rank.KING
                || card.getRank() == Rank.ACE;
    }
}
