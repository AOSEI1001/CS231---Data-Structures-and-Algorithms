import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /**
     * Creates the underlying deck as an ArrayList of Card objects.
     * Calls build() as a subroutine to build the deck itself.
     */

    ArrayList<Card> NewDeck;

    public Deck() {

        NewDeck = new ArrayList<Card>();

        build();

    }

    /**
     * Builds the underlying deck as a standard 52 card deck.
     * Replaces any current deck stored.
     */
    public void build() {
        // int sizeDeck = NewDeck.size();

        NewDeck.clear();

        for (int i = 0; i < 16; i++) {

            NewDeck.add(new Card(10)); // adds new card with a value of 10
            // .add(10);
        }

        for (int i = 0; i < 4; i++) {

            NewDeck.add(new Card(2));
            NewDeck.add(new Card(3));
            NewDeck.add(new Card(4));
            NewDeck.add(new Card(5));
            NewDeck.add(new Card(6));
            NewDeck.add(new Card(7));
            NewDeck.add(new Card(8));
            NewDeck.add(new Card(9));
            NewDeck.add(new Card(11));

        }

    }

    /**
     * Returns the number of cards left in the deck.
     * 
     * @return the number of cards left in the deck
     */
    public int size() {

        int numOfCards = NewDeck.size();

        return numOfCards;
    }

    /**
     * Returns and removes the first card of the deck.
     * 
     * @return the first card of the deck
     */
    public Card deal() {

        Card card = NewDeck.remove(0); // Remove and return the first card.
        return card;
        // return NewDeck.get(0);
    }

    /**
     * Shuffles the cards currently in the deck.
     */
    public void shuffle() {

        // int deckSize = NewDeck.size();

        // System.out.println(deckSize);

        Random ran = new Random();

        ArrayList<Card> FinalDeck = new ArrayList<Card>();

        while (NewDeck.size() != 0){
            // System.out.println(NewDeck.size());


            int val = ran.nextInt(NewDeck.size());
            Card card = NewDeck.get(val);

            FinalDeck.add(card);
            NewDeck.remove(val);
        }

        NewDeck = FinalDeck;

      


        

    }

    /**
     * Returns a string representation of the deck.
     * 
     * @return a string representation of the deck
     */

    public String toString() {

        return NewDeck.toString();
    }

}
