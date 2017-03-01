package poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        DeckOfCards dealDeck = new DeckOfCards();


        dealDeck.reset();

        HandOfCards hand = new HandOfCards(dealDeck);

//  Hand setter and test output
// Added second hand to test close hands for correct ranking
        HandOfCards testHand = new HandOfCards(dealDeck);
        HandOfCards testHand2 = new HandOfCards(dealDeck);


        // testHand1
        testHand.setHand(0, new PlayingCard("A", PlayingCard.HEARTS, 1, 14));
        testHand.setHand(1, new PlayingCard("K", PlayingCard.HEARTS, 13, 13));
        testHand.setHand(2, new PlayingCard("J", PlayingCard.HEARTS, 11, 11));
        testHand.setHand(3, new PlayingCard("10", PlayingCard.HEARTS, 10, 10));
        testHand.setHand(4, new PlayingCard("9", PlayingCard.CLUBS, 9, 9));

        System.out.println("Hand: " + testHand.toString());
        System.out.println(testHand.checkHand());
        System.out.println("Hand value: " + testHand.getGameValue() + "\n");
        for (int i=0; i<5; i++){
            System.out.println(testHand.getDiscardProbability(i));
        }

        // testHand2
        testHand2.setHand(0, new PlayingCard("A", PlayingCard.HEARTS, 1, 14));
        testHand2.setHand(1, new PlayingCard("K", PlayingCard.CLUBS, 13, 13));
        testHand2.setHand(2, new PlayingCard("Q", PlayingCard.CLUBS, 12, 12));
        testHand2.setHand(3, new PlayingCard("9", PlayingCard.DIAMONDS, 9, 9));
        testHand2.setHand(4, new PlayingCard("8", PlayingCard.DIAMONDS, 8, 8));

        System.out.println("Hand: " + testHand2.toString());
        System.out.println(testHand2.checkHand());
        System.out.println("Hand value: " + testHand2.getGameValue() + "\n");
        for (int i=0; i<5; i++){
            System.out.println(testHand2.getDiscardProbability(i));
        }



        System.out.println("Hand: " + hand.toString());
        System.out.println(hand.checkHand());
        System.out.println("Hand value: " + hand.getGameValue());
        for (int i=0; i<5; i++){
            System.out.println(hand.getDiscardProbability(i));
        }

    }
}
