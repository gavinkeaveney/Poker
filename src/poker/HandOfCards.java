package poker;

import java.util.ArrayList;
import java.util.Collections;


public class HandOfCards {
    public static int HAND_SIZE = 5;
    public ArrayList<PlayingCard> hand = new ArrayList<>();

    HandOfCards(DeckOfCards deck) {

        for (int i = 0; i<HAND_SIZE; i++) {
            hand.add(deck.dealNext());
        }
        sort();

    }

    private void sort() {
        for (int i = 0; i < HAND_SIZE; i++){
            for (int j = 0; j < HAND_SIZE-1; j++){
                if (hand.get(j).getFaceValue() > hand.get(j+1).getFaceValue()) {
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

/*
    boolean isRoyalFlush()
    boolean isStraightFlush()
    boolean isFourOfAKind()
    boolean isThreeOfAKind()
    boolean isFullHouse()
    boolean isStraight()
    boolean isFlush()
    boolean isTwoPair()
    boolean isOnePair()
    boolean isHighHand()
*/
}
