
import java.awt.Color;
import java.awt.Graphics;
import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * name: Abisa Osei-Amankwah
 * purpose: JobDispatcher.java
 * last updated: 10/23/23
 */

public abstract class JobDispatcher {

    protected ArrayList<Server> Servers;
    private float systemTime;
    private ServerFarmViz serverFarmViz;
    private boolean showViz;
    private int totalHandled; 

    /**
     * constructs a JobDispatcher with k total Servers.
     * Make sure this initializes all the fields of this class to appropriate values
     * 
     * @param k
     * @param showViz
     */
    public JobDispatcher(int k, boolean showViz) {

        this.Servers = new ArrayList<Server>(k);
        this.systemTime = 1; // not updateing at all 
        this.serverFarmViz = new ServerFarmViz(this);
        this.showViz = showViz;
        this.totalHandled = 0;

        for( int i = 0; i < k; i++){
            
            Server newServer = new Server();

            this.Servers.add(newServer);
            
        }

    }

    /**
     * as specified above, this method is abstract as we don't know how to implement
     * this method
     * without knowing what particular algorithm we are following for handling our
     * jobs.
     * 
     * @param j
     * @return
     */
    public abstract Server pickServer(Job j);

    /**
     * returns the time
     * 
     * @return
     */
    public float getTime() {

        return systemTime;

    }

    /**
     * returns the jobDispatcher's collection of Servers
     * 
     * @return
     */
    public ArrayList<Server> getServerList() {

        return Servers;

    }

    /**
     * this method updates the current time to the specified time and calls the
     * processTo method for each Server it maintains.
     * 
     * @param time
     */
    public void advanceTimeTo(double time) {

        for (Server server : Servers) {
            server.processTo(time);
        }

        systemTime = (float) time;

    }

    /**
     * advances the time to job's arrival time, if showViz is true, it calls the
     * ServerFarmViz object'srepaint() method,
     * picks the Server appropriate for job (whichever one is returned by the
     * pickServer method),
     * and adds job to the chosen Server, then, if showViz is true, it calls the
     * ServerFarmViz object'srepaint() method again.
     * 
     * @param job
     */
    public void handleJob(Job job) {

        advanceTimeTo(job.getArrivalTime());

        if (showViz == true) {

            serverFarmViz.repaint();

        }

        Server selectedServer = pickServer(job);

        if (selectedServer != null) {
            selectedServer.addJob(job); // i hate you

        } 
        else {
            System.err.println("No server available to handle job ");
        }

        if (showViz == true) {

            serverFarmViz.repaint();

        }

    }

    /**
     * advances the time to the earliest point when all jobs will have completed.
     */
    public void finishUp() {

        double minJob = 10000000.0;

        for (Server server : Servers) {
 
            for (Job job : server.jobQueue) {
                double initalJob = job.getFinishTime();
                System.out.println(initalJob);

                if (initalJob < minJob) {
                    minJob = initalJob;
                }

            }
        }

        advanceTimeTo(minJob);

    }

    /**
     * polls each Job from the specified queue of Jobs and calls handleJob on them.
     * After all the Jobs have been handled, calls finishUp()
     * 
     * @param jobs
     */
    public void handleJobs(Queue<Job> jobs) {

        while (jobs.size() > 0) {

            Job polledJob = jobs.poll();

            handleJob(polledJob);

            totalHandled++;

        }

        finishUp();

    }

    /**
     * gets the total number of jobs handled across all Servers.
     * 
     * @return
     */
    public int getNumJobsHandled() {

        return totalHandled;

    }

    /**
     * gets the total waiting time for each Server, adds them together, and divides
     * it by the number of jobs handled across all Servers.
     * 
     * 
     * @return
     */
    public double getAverageWaitingTime() {

        int numJobs = 0;

        double total = 0.0;

        for (Server server : Servers) {
            for (Job job : server.jobQueue) {

                total += job.getTotalProcessingTime();
                numJobs++;

            }
        }

        double result = total / numJobs;

        return result;

    }

    public void draw(Graphics g) {
        double sep = (ServerFarmViz.HEIGHT - 20) / (getServerList().size() + 2.0);
        g.drawString("Time: " + getTime(), (int) sep, ServerFarmViz.HEIGHT - 20);
        System.out.println(getTime());
        g.drawString("Jobs handled: " + getNumJobsHandled(), (int) sep, ServerFarmViz.HEIGHT - 10);
        for (int i = 0; i < getServerList().size(); i++) {
            ((Server) getServerList().get(i)).draw(g, (i % 2 == 0) ? Color.GRAY : Color.DARK_GRAY, (i + 1) * sep,
                    getServerList().size());
        }
    }

}
