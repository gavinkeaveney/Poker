package poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DeckOfCards dealDeck = new DeckOfCards();
        ArrayList<PlayingCard> hand = new ArrayList<>();

        dealDeck.reset();
        for (int i=0; i<52; i++) {
            if (i % 2 == 0) {
                hand.add(dealDeck.dealNext());
            }
            else {
                dealDeck.returnCard(dealDeck.dealNext()); // return every second card
            }
        }

        System.out.println("Hand: " + hand);

    }
}
