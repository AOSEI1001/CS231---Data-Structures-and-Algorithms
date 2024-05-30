/**
 * name: Abisa Osei-Amankwah
 * purpose: ServerFarmSimulation.java
 * last updated: 10/23/23
 */
public class ServerFarmSimulation {
    public static void main(String[] args) {

        if(args.length < 2){

            System.out.println("Usage: ServerFarmSimulation <number of servers> <file_name>");
        }
    
        int numberOfServers = Integer.parseInt(args[0]);

        String jobSequenceFile = args[1];

        Queue<Job> jobs = Job.readJobFile(jobSequenceFile);
        
        JobDispatcher jdRand = new RandomDispatcher(numberOfServers , false);

        JobDispatcher jdRobin = new RoundRobinDispatcher(numberOfServers , false);

        JobDispatcher jdShort = new ShortestQueueDispatcher(numberOfServers , false);

        JobDispatcher jdLazy = new LeastWorkDispatcher(numberOfServers , false);

        jdRand.handleJobs(jobs);

        jdRobin.handleJobs(jobs);

        jdShort.handleJobs(jobs);

        jdLazy.handleJobs(jobs);

        double randWaitingTime = jdRand.getAverageWaitingTime();

        double robinWaitingTime = jdRobin.getAverageWaitingTime();

        double shortWaitingTime = jdShort.getAverageWaitingTime();

        double leastWaitingTime = jdLazy.getAverageWaitingTime();

        System.out.println("Random Dispatcher: " + randWaitingTime);

        System.out.println("Round Robin Dispatcher: " + robinWaitingTime);

        System.out.println("Shortest Queue Dispatcher: " + shortWaitingTime);

        System.out.println("Least Work Dispatcher: " + leastWaitingTime);

        


        

    }
    

    
}

