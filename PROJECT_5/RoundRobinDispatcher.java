/**
 * name: Abisa Osei-Amankwah
 * purpose: RoundRobin Dispatcher.java
 * last updated: 10/23/23
 */

public class RoundRobinDispatcher extends JobDispatcher{


    public RoundRobinDispatcher(int k, boolean showViz) {

        super(k, showViz);


    }
    int next = 0;

    @Override
    public Server pickServer(Job j) {

        if (getServerList().isEmpty()){
            Server newServer = new Server(); 
            getServerList().add(newServer);
           
        }

        next = next % getServerList().size();
        
        
        // return getServerList().get(next);
        return getServerList().get(next++);
    }
    
}
