/**
 * name: Abisa Osei-Amankwah
 * purpose: Extension dispatcher 
 * last updated: 10/23/23
 */

public class RatioMinimizingDispatcher extends JobDispatcher {

    public RatioMinimizingDispatcher(int k, boolean showViz) {

        super(k, showViz);
    }

    @Override
    /**
     * 
     */
    public Server pickServer(Job j) {

        if (getServerList().isEmpty()) {

            Server newServer = new Server();

            getServerList().add(newServer);

            return newServer;

        }
         else {
            // Calculate the ratio of job size to estimated service time
            double minRatio = Double.MAX_VALUE;

            Server selectedServer = null;

            for (Server server : getServerList()) {

                // Estimate service time based on current queue size
                double estimatedServiceTime = server.remainingWorkInQueue() / server.size();

                // Calculate the ratio
                double ratio = j.getTotalProcessingTime() / estimatedServiceTime;

                if (ratio < minRatio) {

                    minRatio = ratio;

                    selectedServer = server;
                }
            }

            return selectedServer;
        }
    }
}
