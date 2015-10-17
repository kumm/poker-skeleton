/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import com.wcs.poker.gamestate.Suit;
import java.util.List;

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

    public static boolean isSzin(List<Card> cards){
        if(cards.isEmpty()){
            return false;
        }
        Suit suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if(card.getSuit()!=suit){
                return false;
            }
        }
        return true;
    }

}
