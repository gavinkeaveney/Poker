package poker;

import java.util.ArrayList;

public class DeckOfCards {
    private static int ACE_GAME_VALUE = 14;
    private static int SHUFFLE_TIMES = 2705;

    private ArrayList<PlayingCard> deck = new ArrayList<>();
    private ArrayList<PlayingCard> returned = new ArrayList<>();
    private int deal = -1;
    private int returnedTracker = 0;

    DeckOfCards () {
    }

    void reset() {
        String[] cardTypes = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int currentValue = ACE_GAME_VALUE; // set gameValue for Ace = 14

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.HEARTS, i+1, currentValue));
            currentValue = i+2;
        }
        currentValue = ACE_GAME_VALUE;
        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.DIAMONDS, i+1, currentValue));
            currentValue = i+2;
        }
        currentValue = ACE_GAME_VALUE;
        for (int i = 0; i< cardTypes.length; i++) {
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.CLUBS, i + 1, currentValue));
            currentValue = i + 2;
        }
        currentValue = ACE_GAME_VALUE;
        for (int i = 0; i< cardTypes.length; i++) {
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.SPADES, i + 1, currentValue));
            currentValue = i + 2;
        }

        for (int i = 0; i<SHUFFLE_TIMES; i++) { // call shuffle 2704 times
            shuffle();
        }

    }

    void shuffle() {

        ArrayList<PlayingCard> temp = new ArrayList<>();

        while(!deck.isEmpty()) {
            int pos1=(int)(Math.random()*deck.size());
            temp.add(deck.get(pos1));
            deck.remove(pos1);
        }
        deck=temp;
    }



    synchronized PlayingCard dealNext() {
        deal++;
        PlayingCard toDeal = deck.get(deal);

        return toDeal;
    }

    void returnCard(PlayingCard discarded) throws Exception {
        if (discarded == null) throw new Exception("returnCard is null");

        returned.add(returnedTracker++, discarded);
    }

}
