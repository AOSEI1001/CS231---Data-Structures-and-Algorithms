/**
 * name: Abisa Osei-Amankwah
 * purpose: LeastWorkDispatcher.java
 * last updated: 10/23/23
 */

public class LeastWorkDispatcher extends JobDispatcher{


    public LeastWorkDispatcher(int k, boolean showViz) {

        super(k, showViz);
        
    }


    @Override
    public Server pickServer(Job j) {

        if(getServerList().isEmpty()){

            Server newServer = new Server(); 
            getServerList().add(newServer);
            return newServer;

        } 
        
        else {
            Server smallest = getServerList().get(0);

            for(Server server : getServerList()){
                if(server.remainingWorkInQueue() < smallest.remainingWorkInQueue()){
                    smallest = server; 
                }
            }

            return smallest;

        }
        
    }
}