/**
 * Created by Gavin on 01/02/2017.
 */
//package TBD;

public class PlayingCard {
    static public final char HEARTS = 'H';
    static public final char DIAMONDS = 'D';
    static public final char CLUBS = 'C';
    static public final char SPADES = 'S';

    private String cardType; // int or char?
    private char suit;
    private int faceValue;
    private int gameValue;

    PlayingCard () {
        return;
    }

    PlayingCard (String type, char cardSuit, int cardFaceValue, int cardGameValue) {
        cardType = type;
        suit = cardSuit;
        faceValue = cardFaceValue;
        gameValue = cardGameValue;
        return;
    }

    public String toString() {
        String cardInfo = cardType;
        cardInfo += suit;
        return cardInfo;
    }

    public char getSuit(){

        return suit;
    }

    public int getFaceValue(){

        return faceValue;
    }

    public int getGameValue(){

        return gameValue;
    }
}
