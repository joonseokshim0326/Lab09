package edu.handong.csee.java.Lab09; // Defining package which our class is in

import java.util.ArrayList; //  Gets  ArrayList  from the package(library)java.util
import java.util.List; // Gets List from the package(library) java.util
import java.util.Scanner; //  Gets the Scanner class from the package(library)java.util

/**
 * Class SalesReporter is designed to generate sales report.
 * By input of names and salaries, calculating average and comparing salesassociates
 * @author jss21300418
 * @since 20180412
 */
public class SalesReporter {
    private double highestSales; // private variable highestSales
    private double averageSales; // private variable average Sales
    private List<SalesAssociate> team = new ArrayList<>(); // ArrayList Declaration
    
    /**
	 *  Method getData Reads the number of sales associates and data 
	 */
    public void getData() // defining method getData
    {
        Scanner keyboard = new Scanner(System.in); // input from keyboard
        System.out.println("Enter number of sales associates: ");// print out text
        int max = keyboard.nextInt();// get number from keyboard input
        for (int i = 0; i < max; i++) // condition of loop
        {
            team.add(new SalesAssociate()); // using ArrayList
            System.out.println("Enter data for associate " + (i + 1)); // print out text
            team.get(i).readInput();// reading input from keyboard
            System.out.println(); //  print out text
        }
    }

	/**
     method computestats computes the average and highest sales figures
	 */
    public void computeStats() // defining method computeStats
    {
        highestSales = 0; // initialize highestSales
        double sum = 0; // initialize sum
        for (int i = 0; i < team.size(); i++) // condition of loop
        {
            SalesAssociate next = team.get(i); // put value from get(i)
            sum += next.getSales(); // add value of nextSales to sum
            if (highestSales < next.getSales()) // condition of implementation
                highestSales = next.getSales(); //highest sales among sales of associates
        }
        averageSales = sum / team.size(); // compute average of sales
    }

    /**
    method displayResults displays sales report on the screen
	 */
    public void displayResults() // defining method displayResults
    {
        System.out.println("Average sales per associate is $" + averageSales); // print out text
        System.out.println("The highest sales figure is $" + highestSales); // print out text
        System.out.println(); // print out text
        System.out.println("The following had the highest sales:"); // print out text
        for (int i = 0; i < team.size(); i++) // condition of loop
        {
            SalesAssociate next = team.get(i); // put value from get
            if (next.getSales() == highestSales) // implementation condition
            {
                next.writeOutput(); // write out
                System.out.println("$" + (next.getSales() - averageSales) + " above the average.");//  print out text
                System.out.println();//  print out text
            }
        }
        System.out.println("The rest performed as follows:");//  print out text
        for (int i = 0; i < team.size(); i++) // condition of loop
        {
            SalesAssociate next = team.get(i);// put value from get
            if (next.getSales() != highestSales) // implementation condition
            {
                next.writeOutput(); // write out
                if (next.getSales() >= averageSales)// implementation condition
                    System.out.println("$" + (next.getSales() - averageSales) + " above the average.");//  print out text
                else // other implementation condition
                    System.out.println("$" + (averageSales - next.getSales()) + " below the average.");//  print out text
                System.out.println();//  print out text
            }
        }
    }
    /**
	 * This is main method that starts our program
	 * @param args
	 */
    public static void main(String[] args) {
        SalesReporter clerk = new SalesReporter();// instantiate clerk
        clerk.getData();// method getData
        clerk.computeStats();// method computeStats
        clerk.displayResults();// displayResults
    }
}
