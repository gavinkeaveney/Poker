package poker;

import java.util.ArrayList;
import java.util.Collections;


public class HandOfCards {
    public static int HAND_SIZE = 5;
    private static int ACE_GAME_VALUE = 14;
    private static int TEN_GAME_VALUE = 10;
    private static int HIGH_CARD_CLEARANCE = 20;

    // Default hand weighting values
    private static int ROYAL_FLUSH_WEIGHT = 3000000; // 3 million
    private static int STRAIGHT_FLUSH_WEIGHT = 2950000; // 2.95 million
    private static int FOUR_OF_A_KIND_WEIGHT = 2900000; // 2.9 million
    private static int FULL_HOUSE_WEIGHT = 2800000; // 2.8 million
    private static int FLUSH_WEIGHT = 2700000; // 2.7 million
    private static int STRAIGHT_WEIGHT = 2600000; // 2.6 million
    private static int THREE_OF_A_KIND_WEIGHT = 2550000; // 2.55 million
    private static int TWO_PAIRS_WEIGHT = 2500000; // 2.5 million
    private static int ONE_PAIR_WEIGHT = 1400000; // 1.4 million
    private static int HIGH_HAND_WEIGHT = 1;

    public ArrayList<PlayingCard> hand = new ArrayList<>();
    private DeckOfCards deckForHand = new DeckOfCards();

    private boolean isRoyalFlush = false;
    private boolean isStraightFlush = false;
    private boolean isFourOfAKind = false;
    private boolean isFullHouse = false;
    private boolean isFlush = false;
    private boolean isStraight = false;
    private boolean isThreeOfAKind = false;
    private boolean isTwoPair = false;
    private boolean isOnePair = false;
    private boolean isHighHand = false;


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
                if (hand.get(j).getGameValue() < hand.get(j+1).getGameValue()) { // Ordered in descending order (high - low)
                    Collections.swap(hand, j, j+1);
                }
            }
        }
    }

    // HAND RANKING BELOW

    public int getGameValue(){

        int sumGameValue = 0;
        int highCard = 0;
        int i = 0;

        if (isRoyalFlush) {

            return ROYAL_FLUSH_WEIGHT; // Highest hand, if draw split pot

        } else if (isStraightFlush) {

            highCard = hand.get(0).getGameValue();
            return STRAIGHT_FLUSH_WEIGHT + highCard; // Winner will depend on high card

        } else if (isFourOfAKind) {

            if (hand.get(0).getGameValue() == hand.get(1).getGameValue()) {
                highCard = hand.get(0).getGameValue();
            } else {
                highCard = hand.get(1).getGameValue();
            }
            return FOUR_OF_A_KIND_WEIGHT + highCard; // Checks position of high card value, winner has highest match

        } else if (isFullHouse) {

            if ((hand.get(2).getGameValue() == (hand.get(3).getGameValue())) && ((hand.get(3).getGameValue()) == (hand.get(4).getGameValue()))) { // 3=4=5
                highCard = hand.get(2).getGameValue();
            } else { // 1=2=3
                highCard = hand.get(0).getGameValue();
            }

            return FULL_HOUSE_WEIGHT + highCard; // Highest 3 pair wins

        } else if (isFlush) {

            for (i=0;i<HAND_SIZE;i++) {
                sumGameValue += hand.get(i).getGameValue();
            }
            return FLUSH_WEIGHT + sumGameValue; // Highest ranked hand wins

        }else if (isStraight) {

            highCard = hand.get(0).getGameValue();

            return STRAIGHT_WEIGHT + highCard; // Winner depends on high card, draw split pot

        }else if (isThreeOfAKind) {

            if (hand.get(0).getGameValue() == (hand.get(2).getGameValue())) { // 0&2
                highCard = hand.get(0).getGameValue();
            } else { // 2&4
                highCard = (hand.get(2).getGameValue());
            }

            return THREE_OF_A_KIND_WEIGHT + highCard; // Highest matching three wins

        }else if (isTwoPair) {

            // Find highest pair and assign hand value based on it
            // Clearance required so higher card pair wins
            // Double clearance to ensure higher card pair wins
            // Adds spare card for draw situations

            if (hand.get(0).getGameValue() == hand.get(1).getGameValue() && hand.get(2).getGameValue() == hand.get(3).getGameValue()) { // 0&1,2&3
                if (hand.get(0).getGameValue() > hand.get(2).getGameValue()) {
                    sumGameValue = (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(2).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(2).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(4).getGameValue();

                } else {
                    sumGameValue = (hand.get(2).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(2).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(4).getGameValue();

                }
            } else if (hand.get(0).getGameValue() == hand.get(1).getGameValue() && hand.get(3).getGameValue() == hand.get(4).getGameValue()) { // 0&1,3&4
                if (hand.get(0).getGameValue() > hand.get(3).getGameValue()) {
                    sumGameValue = (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(2).getGameValue();

                } else {
                    sumGameValue = (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(0).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(2).getGameValue();

                }
            } else if (hand.get(1).getGameValue() == hand.get(2).getGameValue() && hand.get(3).getGameValue() == hand.get(4).getGameValue()) {// 1&2,3&4
                if (hand.get(1).getGameValue() > hand.get(3).getGameValue()) {
                    sumGameValue = (hand.get(1).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(1).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(0).getGameValue();

                } else {
                    sumGameValue = (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE*2) * (hand.get(3).getGameValue() + (HIGH_CARD_CLEARANCE*2)));
                    sumGameValue += (hand.get(1).getGameValue() + (HIGH_CARD_CLEARANCE) * (hand.get(1).getGameValue() + (HIGH_CARD_CLEARANCE)));
                    sumGameValue += hand.get(0).getGameValue();

                }
            }

            return TWO_PAIRS_WEIGHT + sumGameValue; // Highest pair - highest second pair - highest side card

        }else if (isOnePair) {

            // Gets value of pair
            // Multiply with Clearance to ensure high card pair wins
            // Adds rest of cards for draw situations - could be refined

            for (i=0;i<HAND_SIZE-1;i++){
                if (hand.get(i).getGameValue() == hand.get(i+1).getGameValue()) {
                    highCard = hand.get(i).getGameValue();
                }
            }

            highCard = (highCard+HIGH_CARD_CLEARANCE) * (highCard+HIGH_CARD_CLEARANCE);

            for (i=0;i<HAND_SIZE;i++) {
                highCard += hand.get(i).getGameValue();
            }


            return ONE_PAIR_WEIGHT + highCard; // highest pair - highest side - next highest - next highest

        }else if (isHighHand) {

            // Requires some refinement
            // Weights higher cards to ensure highest card wins

            sumGameValue = hand.get(0).getGameValue() * hand.get(0).getGameValue() * HIGH_CARD_CLEARANCE * 250;
            sumGameValue += hand.get(1).getGameValue() * hand.get(1).getGameValue() * HIGH_CARD_CLEARANCE * 100;
            sumGameValue += hand.get(2).getGameValue() * hand.get(2).getGameValue() * HIGH_CARD_CLEARANCE * 10;
            sumGameValue += hand.get(3).getGameValue() * hand.get(3).getGameValue() * HIGH_CARD_CLEARANCE;
            sumGameValue +=  hand.get(4).getGameValue();

            return HIGH_HAND_WEIGHT + sumGameValue;

        }else {
            return -1;
        }

        //return handGameValue;
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
            isRoyalFlush = true;
            return "Royal Flush";
        } else if (isStraightFlush()) {
            isStraight = true;
            return "Straight Flush";
        } else if (isFourOfAKind()) {
            isFourOfAKind = true;
            return "Four of a Kind";
        } else if (isFullHouse()) {
            isFullHouse = true;
            return "Full House";
        } else if (isFlush()) {
            isFlush = true;
            return "Flush";
        } else if (isStraight()) {
            isStraight = true;
            return "Straight";
        } else if (isThreeOfAKind()) {
            isThreeOfAKind = true;
            return "Three of a Kind";
        } else if (isTwoPair()) {
            isTwoPair = true;
            return "Two Pair";
        } else if (isOnePair()) {
            isOnePair = true;
            return "One Pair";
        } else {
            isHighHand = true;
            return "High Hand";
        }
    }

// Public method to set hand to test checkHand
    public void setHand(int index, PlayingCard card) {
        hand.add(index, card);
    }


    // CHECKS HAND FUNCTIONS BELOW


    private boolean isRoyalFlush() {
        if (hand.get(0).getGameValue()== ACE_GAME_VALUE && hand.get(1).getGameValue()== TEN_GAME_VALUE && isStraightFlush()) {
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
        if ((hand.get(0).getGameValue() - hand.get(1).getGameValue() == 1) && (hand.get(1).getGameValue() - hand.get(2).getGameValue() == 1) && (hand.get(2).getGameValue() - hand.get(3).getGameValue() == 1) && (hand.get(3).getGameValue() - hand.get(4).getGameValue() == 1)) {
            return true;
        } else if (hand.get(0).getGameValue() - hand.get(1).getGameValue() == 1) {
            if (hand.get(1).getGameValue() - hand.get(2).getGameValue() == 1) {
                if (hand.get(2).getGameValue() - hand.get(3).getGameValue() == 1) {
                    if (hand.get(3).getGameValue() - hand.get(4).getGameValue() == 1) {
                        return true; // Checks cards in descending order. Takes account of Ace low straight
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
