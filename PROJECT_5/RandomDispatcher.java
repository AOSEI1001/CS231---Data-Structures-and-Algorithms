/**
 * name: Abisa Osei-Amankwah
 * purpose: RandomDispatcher.java
 * last updated: 10/23/23
 */

import java.util.Random;

public class RandomDispatcher extends JobDispatcher{

    private Random rand; 

    public RandomDispatcher(int k, boolean showViz){
        super(k, showViz);

        rand = new Random();
    }

    
    @Override
    /**
     * 
     */
    public Server pickServer(Job j) {

        if (getServerList().isEmpty()){
            Server newServer = new Server(); 
            getServerList().add(newServer);

            // return null;
           
        }
        
        int randIndex = rand.nextInt(getServerList().size());

        return getServerList().get(randIndex);
    }
    
}
