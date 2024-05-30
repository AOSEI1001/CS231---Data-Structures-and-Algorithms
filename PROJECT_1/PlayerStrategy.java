public class PlayerStrategy extends Blackjack{
    public PlayerStrategy () {
        super();
    }

    public boolean playerTurn() {

        
		return playerHand.getTotalValue() < 22;


    }

    // player want to hit and adds another card to the hand, chances of busting are low at 13 and lower
    public void handValueStrategy() {
        while (playerHand.getTotalValue() < 13) {
			playerHand.add(deck.deal());
		}

    }

    //player wants to hit and add another card to their hand, when value of hand divded by the num of card is less than four
    // chances of busting is lower 
    public void averageStrategy() {
        while (playerHand.getTotalValue() / playerHand.size() < 4) {
			playerHand.add(deck.deal());
		}

    }

}
