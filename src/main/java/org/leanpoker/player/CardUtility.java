/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Rank;
import com.wcs.poker.gamestate.Suit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peter
 */
public class CardUtility {

    public static boolean isFiguras(Card card) {
        return card.getRank() == Rank.JACK
                || card.getRank() == Rank.QUEEN
                || card.getRank() == Rank.KING
                || card.getRank() == Rank.ACE;
    }

    public static boolean isSzin(List<Card> cards) {
        if (cards.isEmpty()) {
            return false;
        }
        Suit suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    public static Map<Rank, Integer> getRanks(List<Card> cards) {
        Map<Rank, Integer> ranks = new HashMap();
        for (Card card : cards) {
            if (ranks.containsKey(card.getRank())) {
                int sum = ranks.get(card.getRank());
                sum++;
                ranks.put(card.getRank(), sum);
            } else {
                ranks.put(card.getRank(), 1);
            }
        }
        return ranks;
    }

    public static int getPar(Map<Rank, Integer> map) {
        int par = 0;
        for (Integer value : map.values()) {
            if (value == 2) {
                par++;
            }
        }
        return par;
    }

}
