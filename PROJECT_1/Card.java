//package lab_01;

public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * 
     * @param val
     */
    public Card(int val) {
        // TBD

        this.value = val;

    }

    /**
     * Returns the value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        // TBD

        return value;
    }

    /**
     * Returns a string representation of this card.
     * 
     * @return a string representation of this card
     */
    public String toString() {
        // TBD

        String cardString = "error";

        
        if (this.value == 1) {
            cardString = "1";
            return cardString;

        }

        else if (this.value == 2) {
            cardString = "2";
            return cardString;
        }

        else if (this.value == 3) {
            cardString = "3";
            return cardString;
        }

        else if (this.value == 4) {
            cardString = "4";
            return cardString;
        }

        else if (this.value == 5) {
            cardString = "5";
            return cardString;
        }

        else if (this.value == 6) {
            cardString = "6";
            return cardString;
        }

        else if (this.value == 7) {
            cardString = "7";
            return cardString;
        }

        else if (this.value == 8) {
            cardString = "8";
            return cardString;
        }

        else if (this.value == 9) {
            cardString = "9";
            return cardString;
        }

        else if (this.value == 10) {
            cardString = "10";
            return cardString;
        }

        else if (this.value == 11) {
            cardString = "11";
            return cardString;
        } 
        else {
            cardString = "Unknown";
        }

        return cardString.toString();


    }

    public static void main (String args[]){
        System.out.println("Hello");
    }
}