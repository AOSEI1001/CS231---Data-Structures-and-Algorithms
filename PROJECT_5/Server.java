/**
 * name: Abisa Osei-Amankwah
 * purpose: Server.java
 * last updated: 10/23/23
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.awt.Font;



public class Server {

    private int numJobsProcessed;
    private double systemTime;
    private float totalWaitTime;
    public LinkedLists<Job> jobQueue;
    /**
     * this constructor initializes whatever fields the Server will need in order for it to support the other methods. The Server can assume that
     *  the system time, number of jobs processed, and total wait time will all start at 0 at its initialization. The Queue of jobs will be empty.
     */
    public Server() {

       numJobsProcessed = 0;
       systemTime = 0;
       totalWaitTime = 0;
       jobQueue = new LinkedLists<Job>();

    }

    /**
     * adds the specified Job job into the queue.
     * @param job
     */
    public void addJob(Job job) {

        jobQueue.offer(job);

    }


    /**
     * advances the system time of this queue to the specified time time
     * @param time
     */

    //get a step by steps on how to implement this method 
    public void processTo(double time){

        int totalProcessedJob = 0;

        while(!jobQueue.isEmpty() && time > 0){

            Job currentJob = jobQueue.peek();

            // currentJob.process(time);


            if (time < currentJob.getTimeRemaining()){

                currentJob.process(time);
            }
            else {

                //processes the job for the remaining time
                currentJob.process(currentJob.getTotalProcessingTime());

                //sets the finish time 
                currentJob.setFinishTime(systemTime + currentJob.getTimeRemaining());

                //increases the num of jobs processed 
                totalProcessedJob++;

                //takes away the current job 
                jobQueue.poll();
                
                
                // time -= currentJob.g();
                totalWaitTime += currentJob.timeInQueue();
                //new current
                // currentJob = jobQueue.peek();
            }

            
        }

        // systemTime += time; 
        

    }


    /**
     * returns the total remaining processing time in this Server's queue
     * @return
     */
    public double remainingWorkInQueue(){

        double remainingWork = 0;
        for (Job job : jobQueue) {
            remainingWork += job.getTimeRemaining();
        }
        return remainingWork;

        // return systemTime + totalWaitTime;

    }


    /**
     * returns the number of Jobs in this Server's queue
     * @return
     */
    public int size(){

        return jobQueue.size();

    }


    /**
     * 
     * @param g
     * @param c
     * @param loc
     * @param numberOfServers
     */
    public void draw(Graphics g, Color c, double loc, int numberOfServers){

        double sep = (ServerFarmViz.HEIGHT - 20) / (numberOfServers + 2.0);
        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(), (int) (72.0 * (sep * .5) / Toolkit.getDefaultToolkit().getScreenResolution())));
        g.drawString("Work: " + (remainingWorkInQueue() < 1000 ? remainingWorkInQueue() : ">1000"), 2, (int) (loc + .2 * sep));
        g.drawString("Jobs: " + (size() < 1000 ? size() : ">1000"), 5 , (int) (loc + .55 * sep));
        g.setColor(c); 
        g.fillRect((int) (3 * sep), (int) loc, (int) (.8 * remainingWorkInQueue()), (int) sep);
        g.drawOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
        if (remainingWorkInQueue() == 0) g.setColor(Color.GREEN.darker());
        else g.setColor(Color.RED.darker());
        g.fillOval(2 * (int) sep, (int) loc, (int) sep, (int) sep);
    }
    


    
}
