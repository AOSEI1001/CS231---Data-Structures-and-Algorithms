public class Simulation {

    public static void main(String[]args) {
        int numPlayerWins = 0;

        int numDealerWins = 0;

        int numTies = 0;



        Blackjack games = new Blackjack();


        
    
    for (int i = 1; i < 1001; i++) {

        System.out.println("Game " + i + ":");

            
        int result = games.game(false);
            

        games.game(true);

        if (result == 1) {
                numPlayerWins += 1;
        }

        else if (result == -1) {
            numDealerWins += 1;
        }

        else if (result == 0) {

            numTies += 1;
        }

    }

        double playerPercentage = (double) numPlayerWins/1000*100;
        double dealerPercentage = (double) numDealerWins/1000*100;
        double tiePercentage = (double) numTies/1000*100;

        System.out.println("Player Wins: " + numPlayerWins);
        System.out.println(playerPercentage + " %");
        System.out.println("Dealer Wins: " + numDealerWins);
        System.out.println(dealerPercentage + " %");
        System.out.println("Ties: " + numTies);
        System.out.println(tiePercentage + " %");


    }

}




