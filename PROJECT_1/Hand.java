// package lab_01;

import java.util.ArrayList;

public class Hand {

    /**
     * Creates an empty hand as an ArrayList of Cards.  
     */
    ArrayList <Card> EmptyHand;

    public Hand(){
        EmptyHand = new ArrayList<Card>();
        //the type may have to be card instead od string but idk

    }

    /**
     * Removes any cards currently in the hand. 
     */
    public void reset(){

        // ArrayList <Card> ResetHand =  EmptyHand;
        EmptyHand.clear();

    }

    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        EmptyHand.add(card); 
    }

    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){

        return EmptyHand.size();
    }

    /**
     * Returns the card in the hand specified by the given index. 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){ 

        return EmptyHand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){

        int sum = 0;

        // int[] newHandArray = new int[EmptyHand.size()];

        for (int i = 0; i < EmptyHand.size(); i++) {


            // sum = sum + EmptyHand.get(i);
            sum += EmptyHand.get(i).getValue();

        }

        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){

        ArrayList<String> HandString = new ArrayList<String>();

        for (int i = 0; i < EmptyHand.size(); i++) {
            //convert each index into a string and put it into a different array list or try to convert the whole array list into a array of strings 
            // then return it 

            

            HandString.add(EmptyHand.get(i).toString());
            
        }
        
        return HandString.toString() + " : " + getTotalValue();

        
    }
}
