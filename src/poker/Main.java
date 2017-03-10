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
        testHand.setHand(0, new PlayingCard("A", PlayingCard.HEARTS, 14, 14));
        testHand.setHand(1, new PlayingCard("9", PlayingCard.DIAMONDS, 9, 9));
        testHand.setHand(2, new PlayingCard("8", PlayingCard.CLUBS, 8, 8));
        testHand.setHand(3, new PlayingCard("6", PlayingCard.DIAMONDS, 6, 6));
        testHand.setHand(4, new PlayingCard("5", PlayingCard.CLUBS, 5, 5));

        System.out.println("testHand: " + testHand.toString());
        System.out.println(testHand.checkHand());
        System.out.println("Hand value: " + testHand.getGameValue());
        for (int i=0; i<5; i++){
            System.out.println("cardIndex " + i + ": " + testHand.getDiscardProbability(i));
        }

        // testHand2
        testHand2.setHand(0, new PlayingCard("8", PlayingCard.HEARTS, 8, 8));
        testHand2.setHand(1, new PlayingCard("7", PlayingCard.DIAMONDS, 7, 7));
        testHand2.setHand(2, new PlayingCard("5", PlayingCard.CLUBS, 5, 5));
        testHand2.setHand(3, new PlayingCard("4", PlayingCard.DIAMONDS, 4, 4));
        testHand2.setHand(4, new PlayingCard("3", PlayingCard.CLUBS, 3, 3));

        System.out.println("\ntestHand2: " + testHand2.toString());
        System.out.println(testHand2.checkHand());
        System.out.println("Hand value: " + testHand2.getGameValue());
        for (int i=0; i<5; i++){
            System.out.println("cardIndex " + i + ": " + testHand2.getDiscardProbability(i));
        }


/*
        System.out.println("\nHand: " + hand.toString());
        System.out.println(hand.checkHand());
        System.out.println("Hand value: " + hand.getGameValue());
        for (int i=0; i<5; i++){
            System.out.println("cardIndex " + i + ": " + hand.getDiscardProbability(i));
        }
        /*
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        */

    }
}
