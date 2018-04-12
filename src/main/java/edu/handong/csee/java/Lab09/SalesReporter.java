package edu.handong.csee.java.Lab09; // Defining package which our class is in

import java.util.Scanner; //  Gets the Scanner class from the package(library)java.util
/**
 * Class SalesReporter is designed to generate sales report.
 * By input of names and salaries, calculating average and comparing salesassociates
 * @author jss21300418
 * @since 20180412
 */
public class SalesReporter // defining class Salesreporter
{
	private double highestSales; // private variable highestSales
	private double averageSales; // private variable average Sales
	private SalesAssociate [] team; // array in getData
	private int numberOfAssociates; //Same as team.length

	/**
	 *  Method getData Reads the number of sales associates and data 
	 */
	public void getData () // defining method getData
	{
		Scanner keyboard = new Scanner (System.in); //
		System.out.println ("Enter number of sales associates:"); // print out text 
		numberOfAssociates = keyboard.nextInt (); // get number from keyboard input
		team = new SalesAssociate [numberOfAssociates + 1]; // 
		for (int i = 1 ; i <= numberOfAssociates ; i++) // condition of loop
		{
			team [i] = new SalesAssociate (); // array declaration
			System.out.println ("Enter data for associate " + i); // print out text
			team [i].readInput (); // 
			System.out.println (); //  print out text
		}
	}


	/**
     method computestats computes the average and highest sales figures
	 */
	public void computeStats () // defining method computeStats
	{
		double nextSales = team [1].getSales (); // 
		highestSales = nextSales;
		double sum = nextSales; // 
		for (int i = 2 ; i <= numberOfAssociates ; i++) // conditon of loop
		{
			nextSales = team [i].getSales (); 
			sum = sum + nextSales; // add value of nextSales to sum
			if (nextSales > highestSales) // condition of implementation
				highestSales = nextSales; //highest sales among sales of associates
		}
		averageSales = sum / numberOfAssociates; // compute average of sales
	}


	/**
    method displayResults displays sales report on the screen
	 */
	public void displayResults () // defining method displayResults
	{
		System.out.println ("Average sales per associate is $" +
				averageSales); // print out text
		System.out.println ("The highest sales figure is $" +
				highestSales); // print out text
		System.out.println (); // print out tex
		System.out.println ("The following had the highest sales:");// print out text
		for (int i = 1 ; i <= numberOfAssociates ; i++) // condition of loop
		{
			double nextSales = team [i].getSales (); // put value from get sales
			if (nextSales == highestSales) // implementation condition
			{
				team [i].writeOutput (); // write out
				System.out.println ("$" + (nextSales - averageSales) +
						" above the average."); //  print out text
				System.out.println ();//  print out text
			}
		}
		System.out.println ("The rest performed as follows:");//  print out text
		for (int i = 1 ; i <= numberOfAssociates ; i++) // condition of loop
		{
			double nextSales = team [i].getSales (); // value from getsales
			if (team [i].getSales () != highestSales) // implement condition
			{
				team [i].writeOutput (); // write out
				if (nextSales >= averageSales) // implement condition
					System.out.println ("$" + (nextSales - averageSales)
							+ " above the average."); // print out text
				else // other implement condition
					System.out.println ("$" + (averageSales - nextSales)
							+ " below the average."); // print out text
				System.out.println (); // print out text
			}
		}
	}
	/**
	 * This is main method that starts our program
	 * @param args
	 */
	public static void main (String [] args) // defining main method
	{
		SalesReporter clerk = new SalesReporter (); // instantiate SalesReporter
		clerk.getData (); // method getData
		clerk.computeStats (); // method computeStats
		clerk.displayResults (); // displayResults
	}
}