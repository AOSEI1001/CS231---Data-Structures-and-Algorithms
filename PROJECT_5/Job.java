
/**
 * name: Abisa Osei-Amankwah
 * purpose: job.java
 * last updated: 10/23/23
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;



public class Job {


    private double arrivalTime;
    private double processingTime;
    private double timeProcessed;
    private boolean finished; 
    private double finishedTime; 

    /**
     * 
     * 
     * @param arrivalTime
     * @param processingTime
     */
    public Job(double arrivalTime, double processingTime) {
        this.arrivalTime = arrivalTime; 
        this.processingTime = processingTime;
        this.timeProcessed = 0;
        this.finishedTime = 0; 
        this.finished = false; 

    }

    /**
     * 
     * @return
     */
    public double getArrivalTime() {

        return arrivalTime;

    }


    /**
     * this returns the total necessary processing time of the job.
     * @return
     */
    public double getTotalProcessingTime(){

        return processingTime;

    }


    /**
     *  this returns the time spent working on this job so far
     * @return
     */
    public double getTimeProcessed() {

        return timeProcessed;

    }


    /**
     * this method returns the necessary time remaining to spend working on this job.
     * @return
     */
    public double getTimeRemaining() {

        return processingTime - timeProcessed;

    }

    /**
     *  returns true if this job has been run to completion.
     * @return
     */
    public boolean isFinished(){

        if(finished == true) {
            return true;
        }

        return false; 

    }

    /**
     *  this sets the time when the job completed.
     * @param time
     */
    public void setFinishTime(double time){

        finishedTime = time;

    }

    /**
     * this method returns the time when the job was completed.
     * @return
     */
    public double getFinishTime(){

        return finishedTime;

    }

    /**
     * returns the difference in time between the arrival and finish times of this job.
     * @return
     */
    public double timeInQueue(){

        return finishedTime - arrivalTime;
        
    }

    /**
     * processes this job for the specified time units of time. Make sure that all necessary fields of the class are updated.

     * @param time
     */
    public void process(double time){

        if(!finished){
            
            timeProcessed += time;
        }

        if(timeProcessed >= processingTime){

            finishedTime = arrivalTime + processingTime;
            finished = true;
        }
        


    }
    /**
     * 
     * @param filename
     * @return
     */
    public static Queue<Job> readJobFile(String filename){
    
    try {
        // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
        FileReader fr = new FileReader(filename);
        // assign to a variable of type BufferedReader a new BufferedReader, passing fr to the constructor
        BufferedReader br = new BufferedReader(fr);
        // assign to a variable of type Queue<Job> a new LinkedList.
        Queue<Job> jobSequence = new LinkedLists<Job>();
  
        // assign to a variable of type String line the result of calling the readLine method of the BufferedReader.
        String line = br.readLine();
        // everytime we call br.readLine(), we advance to the next line of the file we are reading. 
        // Since the first line of the job files are just the headers, 
        //   let's skip the first line by calling br.readLine again: 
        line = br.readLine();
        // start a while loop that loops while line isn't null
        while(line != null){
            // assign to an array of type String the result of calling split on the line with the argument ","
            String[] arr = line.split(",");

            // let's see what this array holds: 
            System.out.println("the first item in arr: " + arr[0] + ", the second item in arr: " + arr[1]);

	        // using this String array arr, make a new Job object and offer it into jobSequence:
            
            Job job = new Job(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
       
        	jobSequence.offer(job);
            
            //Read the next line of the file
            line = br.readLine();
        }
        // call the close method of the BufferedReader:
        br.close();
        return jobSequence;
      }
      catch(FileNotFoundException ex) {
        System.out.println("JobReader.read():: unable to open file " + filename + ": file not found");
      }
      catch(IOException ex) {
        System.out.println("JobReader.read():: error reading file " + filename);
      }
  
      return null;
    }

    public static void main(String[]args) {


        if (args.length < 1) {

            System.out.println("Usage: java Job <input_filename>");

            return; 
        }


        String fileName = args[0];

        // Job initalJob = new Job(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
    
        Queue<Job> jobQueue = Job.readJobFile(fileName);

        System.out.println(fileName);

        // Queue<Job> jobQueue = Job.readJobFile(fileName);

        
        



    }

}
