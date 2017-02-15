package poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DeckOfCards dealDeck = new DeckOfCards();


        dealDeck.reset();
        /*
        for (int i=0; i<52; i++) {
            if (i % 2 == 0) {
                hand.add(dealDeck.dealNext());
            }
            else {
                dealDeck.returnCard(dealDeck.dealNext()); // return every second card
            }
        }
        */
        HandOfCards hand = new HandOfCards(dealDeck);
        HandOfCards testHand = new HandOfCards(dealDeck);

/* Hand setter and test output
*
*        testHand.setHand(0, new PlayingCard("A", PlayingCard.HEARTS, 1, 14));
*        testHand.setHand(1, new PlayingCard("K", PlayingCard.CLUBS, 13, 13));
*        testHand.setHand(2, new PlayingCard("Q", PlayingCard.HEARTS, 12, 12));
*        testHand.setHand(3, new PlayingCard("J", PlayingCard.HEARTS, 11, 11));
*        testHand.setHand(4, new PlayingCard("10", PlayingCard.HEARTS, 10, 10));
*
*
*        System.out.println("Hand: " + testHand.toString());
*        System.out.println(testHand.checkHand());
*/

        System.out.println("Hand: " + hand.toString());
        System.out.println(hand.checkHand());

    }
}
