package poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DeckOfCards dealDeck = new DeckOfCards();


        dealDeck.reset();

        HandOfCards hand = new HandOfCards(dealDeck);
/*
//  Hand setter and test output
        HandOfCards testHand = new HandOfCards(dealDeck);

        testHand.setHand(0, new PlayingCard("6", PlayingCard.HEARTS, 6, 6));
        testHand.setHand(1, new PlayingCard("5", PlayingCard.HEARTS, 5, 5));
        testHand.setHand(2, new PlayingCard("4", PlayingCard.HEARTS, 4, 4));
        testHand.setHand(3, new PlayingCard("3", PlayingCard.HEARTS, 3, 3));
        testHand.setHand(4, new PlayingCard("2", PlayingCard.HEARTS, 2, 2));

        System.out.println("Hand: " + testHand.toString());
        System.out.println(testHand.checkHand());

*/
        System.out.println("Hand: " + hand.toString());
        System.out.println(hand.checkHand());

    }
}
