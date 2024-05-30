/**
 * name: Abisa Osei-Amankwah
 * purpose: testing file
 * last updated: 10/23/23
 */

import java.awt.geom.RoundRectangle2D;


public class ServerFarmTester {
    
    public static void main(String[] args){

        Queue<Job> jobs = Job.readJobFile("jobs.txt");

        if (args.length < 1) {

            System.out.println("Usage: java ServerFarmTester <input_Dispatcher>");

            return; 
        }

        else if ("RandomDispatcher".equals(args[0])){

            JobDispatcher jd = new RandomDispatcher(4 , true);
            jd.handleJobs(jobs);

        }
        
        else if ("RoundRobinDispatcher".equals(args[0])){

            JobDispatcher jd2 = new RoundRobinDispatcher(4, true);
            jd2.handleJobs(jobs);
            
        }

        else if ("ShortestQueueDispatcher".equals(args[0])){

            JobDispatcher jd3 = new ShortestQueueDispatcher(4, true);
            jd3.handleJobs(jobs);
            
        }

        else if ("LeastWorkDispatcher".equals(args[0])){

            JobDispatcher jd4 = new LeastWorkDispatcher(4, true);
            jd4.handleJobs(jobs);
            
        }



    }

}
