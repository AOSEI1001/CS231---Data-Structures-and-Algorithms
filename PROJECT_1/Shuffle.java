//package lab_01;


/**
 * Author: Abisa Osei-Amankwah
 * 
 * Purpose: Lab 1
 */

import java.util.ArrayList;

import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {

        ArrayList<Integer> arr0 = new ArrayList<Integer>();

        ArrayList<Integer> arr1 = new ArrayList<Integer>();

        ArrayList<Integer> arr2 = arr0;

        ArrayList<Integer> arr3 = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            Random ran = new Random();

            int val = ran.nextInt(50);

            arr0.add(val);

        }

        for (int i = 0; i < 10; i++) {
            Random ran = new Random();

            int size = arr0.size();

            int val = ran.nextInt(size);

            int index = arr0.get(val);

            
            arr0.remove(val); // removes values from arr0
            arr3.add(index); //adds values from arr0 to the given random index for arr3
            

            System.out.println(arr0);
            System.out.println(arr3);
            

        }

        

       

    }

}

 // System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) +
        // "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " +
        // (arr2.equals(arr0)));

        // System.out.println(arr0);
        // System.out.println(arr1);
        // System.out.println(arr2);
