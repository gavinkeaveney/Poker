package poker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Gavin on 01/02/2017.
 */
public class DeckOfCards {
    private ArrayList<PlayingCard> deck = new ArrayList<>();
    private ArrayList<PlayingCard> returned = new ArrayList<>();
    private int deal = -1;
    private int returnedTracker = 0;


    DeckOfCards () {

    }

    void reset() {
        String[] cardTypes = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int currentValue = 14; // set gameValue for Ace = 14

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.HEARTS, i+1, currentValue));
            currentValue = i+2;
        }
        currentValue = 14;
        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.DIAMONDS, i+1, currentValue));
            currentValue = i+2;
        }
        currentValue = 14;
        for (int i = 0; i< cardTypes.length; i++) {
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.CLUBS, i + 1, currentValue));
            currentValue = i + 2;
        }
        currentValue = 14;
        for (int i = 0; i< cardTypes.length; i++) {
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.SPADES, i + 1, currentValue));
            currentValue = i + 2;
        }

        for (int i = 0; i<2705; i++) { // call shuffle 2704 times
            shuffle();
        }

    }

    void shuffle() {

        ArrayList<PlayingCard> temp = new ArrayList<>();
//        Random random1 = new Random();

        while(!deck.isEmpty()) {
            int pos1=(int)(Math.random()*deck.size());
            temp.add(deck.get(pos1));
            deck.remove(pos1);
        }
        deck=temp;
    }



    PlayingCard dealNext() {
        deal++;
        PlayingCard toDeal = new PlayingCard();

        toDeal = deck.get(deal);
//        deck.remove(deal);

        return toDeal;
    }

    void returnCard(PlayingCard discarded) {

        returned.add(returnedTracker++, discarded);
    }

}
