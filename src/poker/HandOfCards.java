package poker;

import java.util.ArrayList;
import java.util.Collections;


public class HandOfCards {
    public static int HAND_SIZE = 5;
    public ArrayList<PlayingCard> hand = new ArrayList<>();
    private DeckOfCards deckForHand = new DeckOfCards();
/*
    private boolean isRoyalFlush;
    private boolean isStraightFlush;
    private boolean isFourOfAKind;
    private boolean isThreeOfAKind;
    private boolean isFullHouse;
    private boolean isStraight;
    private boolean isFlush;
    private boolean isTwoPair;
    private boolean isOnePair;
    private boolean isHighHand;
*/

    HandOfCards(DeckOfCards deck) {

        deckForHand = deck;
        for (int i = 0; i<HAND_SIZE; i++) {
            hand.add(deckForHand.dealNext());
        }
        sort();
    }

    private void sort() {
        for (int i = 0; i < HAND_SIZE; i++){
            for (int j = 0; j < HAND_SIZE-1; j++){
                if (hand.get(j).getFaceValue() < hand.get(j+1).getFaceValue()) { // Ordered in descending order (high - low)
                    Collections.swap(hand, j, j+1);
                }
            }
        }
    }

    public String toString() {

        String handString = hand.get(0).toString() + " ";
        for (int i = 1; i<HAND_SIZE; i++) {
            handString += hand.get(i).toString() + " ";
        }
        return handString;
    }

    public String checkHand() {

            if (isRoyalFlush()) {
                return "Royal Flush";
            } else if (isStraightFlush()) {
                return "Straight Flush";
            } else if (isFourOfAKind()) {
                return "Four of a Kind";
            } else if (isFullHouse()) {
                return "Full House";
            } else if (isFlush()) {
                return "Flush";
            } else if (isStraight()) {
                return "Straight";
            } else if (isThreeOfAKind()) {
                return "Three of a Kind";
            } else if (isTwoPair()) {
                return "Two Pair";
            } else if (isOnePair()) {
                return "One Pair";
            } else {
                return "High Hand";
            }
    }

/* Public method to set hand to test checkHand
*
*    public void setHand(int index, PlayingCard card) {
*        hand.add(index, card);
*    }
*/

    // CHECKS HAND FUNCTIONS BELOW


    private boolean isRoyalFlush() {
        if (hand.get(0).getGameValue()==14 && isStraightFlush()) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isStraightFlush() {
        if (isStraight()==true && isFlush()==true) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isFourOfAKind() {
        if ((hand.get(0).getGameValue() == hand.get(3).getGameValue()) || (hand.get(1).getGameValue() == hand.get(4).getGameValue())) {
            return true; // 0&3,1&4
        } else {
            return false;
        }
    }
    private boolean isFullHouse() {
        if ((hand.get(0).getGameValue() == (hand.get(1).getGameValue())) && ((hand.get(2).getGameValue() == (hand.get(3).getGameValue())) && ((hand.get(3).getGameValue()) == (hand.get(4).getGameValue())))) {
            return true; // 1=2, 3=4=5
        } else if ((((hand.get(0).getGameValue()) == (hand.get(1).getGameValue())) && (hand.get(1).getGameValue() == (hand.get(2).getGameValue()))) && (hand.get(3).getGameValue() == (hand.get(4).getGameValue()))) {
            return true; // 1=2=3,4=5
        } else {
            return false;
        } // if statements quite long?
    }
    private boolean isFlush() { // Suit ordered sort?
        if (hand.get(0).getSuit() == hand.get(1).getSuit()) {
            if (hand.get(1).getSuit() == hand.get(2).getSuit()) {
                if (hand.get(2).getSuit() == hand.get(3).getSuit()) {
                    if (hand.get(3).getSuit() == hand.get(4).getSuit()) {
                        return true; // Checks suit of each card is same
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }
    private boolean isStraight() {
        if (hand.get(0).getGameValue() - hand.get(1).getGameValue() == 1) {
            if (hand.get(1).getGameValue() - hand.get(2).getGameValue() == 1) {
                if (hand.get(2).getGameValue() - hand.get(3).getGameValue() == 1) {
                    if (hand.get(3).getGameValue() - hand.get(4).getGameValue() == 1) {
                        return true; // Checks cards in descending order
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }
    private boolean isThreeOfAKind() {
        if (((hand.get(0).getGameValue() == (hand.get(2).getGameValue()))) || (hand.get(2).getGameValue() == (hand.get(4).getGameValue()))) {
            return true; // 0&2,2&4 If sorted must mean 3 of kind
        } else {
            return false;
        }
    }
    private boolean isTwoPair() {
        if (hand.get(0).getGameValue() == hand.get(1).getGameValue() && hand.get(2).getGameValue() == hand.get(3).getGameValue()) {
            return true; // 0&1,2&3
        } else if (hand.get(0).getGameValue() == hand.get(1).getGameValue() && hand.get(3).getGameValue() == hand.get(4).getGameValue()) {
            return true; // 0&1,3&4
        } else if (hand.get(1).getGameValue() == hand.get(2).getGameValue() && hand.get(3).getGameValue() == hand.get(4).getGameValue()) {
            return true; // 1&2,3&4
        } else {
            return false;
        }
    }
    private boolean isOnePair() {
        if  (hand.get(0).getGameValue() == hand.get(1).getGameValue()) {
            return true;
        } else if (hand.get(1).getGameValue() == hand.get(2).getGameValue()) {
            return true;
        } else if (hand.get(2).getGameValue() == hand.get(3).getGameValue()) {
            return true;
        } else if (hand.get(3).getGameValue() == hand.get(4).getGameValue()) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isHighHand() { // Last option, will always be true if checked
        return true;
    }


}
