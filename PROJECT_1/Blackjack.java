

public class Blackjack {

    /*
     * this constructor should store the reshuffleCutoff and set up a game.
     * You can avoid duplicate code by calling the reset() method.
     */

    // fields
    public Deck deck;
    public Hand playerHand;
    public Hand dealerHand;
    // private int playerBalance;
    public int reshuffleCutoff;

    public Blackjack(int reshuffleCutoff) {

        this.reshuffleCutoff = reshuffleCutoff;
        reset();

    }

    /*
     * this constructor should call the other constructor with
     * a reasonable cutoff value of your choice.
     */

    public Blackjack() {

        reshuffleCutoff = 20;

    }

    /*
     * should reset the game. Both the player Hand and dealer Hand should start with
     * no cards.
     * If the number of cards in the deck is less than the reshuffle cutoff, then
     * the method should create a fresh (complete), shuffled deck.
     * Otherwise, it should not modify the deck, just clear the player and dealer
     * hands.
     */

    public void reset() {

        playerHand = new Hand();
        dealerHand = new Hand();

        if (deck == null || deck.size() < reshuffleCutoff) {
            deck = new Deck();
            deck.shuffle();

        }

    }

    /*
     * should deal out two cards to both players from the Deck.
     */

    public void deal() {

        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    /*
     * have the player draw cards until the total value of the player's hand is
     * equal to or above 16.
     * The method should return false if the player goes over 21 (bust).
     */

    public boolean playerTurn() {

        while (playerHand.getTotalValue() <= 16) {
            
            playerHand.add(deck.deal());

            if (playerHand.getTotalValue() > 21) {

                return false;

            }

        }
        return true;

    }
    /*
     * have the dealer draw cards until the total of the dealer's hand is equal to
     * or above 17.
     * The method should return false if the dealer goes over 21.
     */

    public boolean dealerTurn() {

        while (dealerHand.getTotalValue() <= 17) {

            dealerHand.add(deck.deal());

        }

        if (dealerHand.getTotalValue() > 21) {

            return false;

        }

        return true;

    }
    /*
     * should assign the new cutoff value to the internal reshuffle cutoff field.
     */

    public void setReshuffleCutoff(int cutoff) {

        this.reshuffleCutoff = cutoff;

    }
    /*
     * returns the current value of the reshuffle cutoff field.
     */

    public int getReshuffleCutoff() {

        return reshuffleCutoff;

    }

    /*
     * returns a String that has represents the state of the game.
     * It may be helpful to show the player and dealer hands as well as their
     * current total value.
     */
    public String toString() {

        String gameState = "Player Hand";

        String gameStateTwo = "Dealer Hand";

        return gameState + playerHand.toString() + "," + gameStateTwo + dealerHand.toString();

    }
    // The game method should return a -1 if the dealer wins, 0 in case of a push
    // (tie), and a 1 if the player wins.
    // If the parameter verbose is true, then the game method should print out the
    // initial and final hands of the game
    // and a statement about the result (dealer/push/player).





    
    //NON-INTERACTIVE CODE


    public int game(boolean verbose) {

        reset();
        deal();

        boolean pResult = playerTurn();
        boolean dResult = dealerTurn();

        if (!pResult) {
            System.out.println("Player busted!");
            return -1;
        }

        if (!dResult){
            
            System.out.println("Dealer busted!");
            return 1;
        }

        if (playerHand.getTotalValue() > dealerHand.getTotalValue()){

            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Player Wins!");

            return 1;

        }

        else if (dealerHand.getTotalValue() > playerHand.getTotalValue()){

            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Player Wins!");

            return -1;

        }


        if (playerHand.getTotalValue() == dealerHand.getTotalValue()) {
            
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Tie!");

            
            return 0;
        }

        else if (playerHand.getTotalValue() == 21) {
        
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Player Wins!");

            return 1;

        } else if (dealerHand.getTotalValue() == 21) {
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Dealer Wins!");

            return -1;

        }

        else if (playerHand.getTotalValue() < 21 && dealerHand.getTotalValue() > 21) {
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Dealer: BUST :(");
            System.out.println("Player Wins!");

            return 1;
        }

        else if (dealerHand.getTotalValue() < 21 && playerHand.getTotalValue() > 21) {

            System.out.println("Player Hand: " + playerHand);
            System.out.println("Dealer Hand: " + dealerHand);
            System.out.println("Player: BUST :(");
            System.out.println("Dealer Wins!");

            return -1;

        }

    return -2;

    }

    public static void main(String[] args) {

        for (int i = 1; i < 4; i++) {

            System.out.println("Game " + i + ":");

            // * NON-INTERACTIVE CODE
            Blackjack games = new Blackjack();

            games.game(true);

            
            
        }

    }

}
