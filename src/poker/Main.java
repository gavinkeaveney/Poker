package poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DeckOfCards dealDeck = new DeckOfCards();


        dealDeck.reset();

        HandOfCards hand = new HandOfCards(dealDeck);

//  Hand setter and test output
        HandOfCards testHand = new HandOfCards(dealDeck);

        testHand.setHand(0, new PlayingCard("A", PlayingCard.CLUBS, 1, 14));
        testHand.setHand(1, new PlayingCard("K", PlayingCard.HEARTS, 13, 13));
        testHand.setHand(2, new PlayingCard("Q", PlayingCard.HEARTS, 12, 12));
        testHand.setHand(3, new PlayingCard("J", PlayingCard.HEARTS, 11, 11));
        testHand.setHand(4, new PlayingCard("9", PlayingCard.HEARTS, 9, 9));

        System.out.println("Hand: " + testHand.toString());
        System.out.println(testHand.checkHand());
        System.out.println("Hand value: " + testHand.getGameValue());



        System.out.println("Hand: " + hand.toString());
        System.out.println(hand.checkHand());
        System.out.println("Hand value: " + hand.getGameValue());

    }
}
