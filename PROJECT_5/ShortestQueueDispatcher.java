/**
 * name: Abisa Osei-Amankwah
 * purpose: ShortestQueueDispatcher.java
 * last updated: 10/23/23
 */

public class ShortestQueueDispatcher extends JobDispatcher{


    public ShortestQueueDispatcher(int k, boolean showViz) {

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

            Server shortest = getServerList().get(0);

            for(Server server : getServerList()){
                if(server.size() < shortest.size()){
                    shortest = server; 
                }
            }

            return shortest;

        }


        
        
    }

    
}
