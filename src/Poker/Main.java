package Poker;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        String[] noOfSuits = {HEARTS, DIAMONDS, CLUBS, SPADES};
        String[] cardTypes = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        PlayingCard card = new PlayingCard();
        ArrayList<PlayingCard> deck = new ArrayList<>();

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.HEARTS, i+1, 14-i));
        }

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.DIAMONDS, i+1, 14-i));
        }

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.CLUBS, i+1, 14-i));
        }

        for (int i = 0; i< cardTypes.length; i++){
            deck.add(new PlayingCard(cardTypes[i], PlayingCard.SPADES, i+1, 14-i));
        }

        for (int i=0; i<deck.size(); i++){
            card = deck.get(i);
            System.out.println(card.toString());
        }
    }
}
