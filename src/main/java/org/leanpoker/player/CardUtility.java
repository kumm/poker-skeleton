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

    public static boolean hasDrill(Map<Rank, Integer> map) {
        for (Integer value : map.values()) {
            if (value == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPoker(Map<Rank, Integer> map) {
        for (Integer value : map.values()) {
            if (value == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSzin(List<Card> allCards) {
        Map<Suit, Integer> suit = new HashMap();
        for (Card card : allCards) {
            if (suit.containsKey(card.getSuit())) {
                int sum = suit.get(card.getSuit());
                sum++;
                suit.put(card.getSuit(), sum);
            } else {
                suit.put(card.getSuit(), 1);
            }
        }

        for (Integer value : suit.values()) {
            if(value == 5){
                return true;
            }
        }
        return false;
    }

}
