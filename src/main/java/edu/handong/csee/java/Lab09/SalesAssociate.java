package edu.handong.csee.java.Lab09;// Defining package which our class is in

import java.util.Scanner; //  Gets the Scanner class from the package(library)java.util
/**
Class SalesAssociate is designed for sales associate records.
@author jss21300418
@since 20180412
 */
public class SalesAssociate // defining class
{
	private String name; // private value name
	private double sales; // private value sales
	/**
	 * method SalesAssociate created instance of an object
	 */
	public SalesAssociate () // method SalesAssociate
	{
		name = "No record"; // instance value of name
		sales = 0; // instance value of sales
	}

	/**
	 * method SalesAssociate created  for initializing
	 * @param initialName
	 * @param initialSales
	 */
	public SalesAssociate (String initialName, 
			double initialSales)// method  SalesAssociatedouble
	{
		set (initialName, initialSales); // setting initial value
	}

	/**
	 * method set is put new value 
	 * @param newName
	 * @param newSales
	 */
	public void set (String newName, double newSales) // method set
	{
		name = newName; // value of newName
		sales = newSales; // value of newSales
	}


	/**
	 * method readinput is for reading input from keyboard
	 */
	public void readInput () // method readInput
	{
		System.out.print ("Enter name of sales associate: "); // print out text
		Scanner keyboard = new Scanner (System.in); // using input from keyboard
		name = keyboard.nextLine (); // value from keyboard
		System.out.print ("Enter associates sales: $"); // print out text
		sales = keyboard.nextDouble (); // value from keyboard
	}

	/**
	 * write down input from keyboard and text
	 */
	public void writeOutput () // method writeOutput
	{
		System.out.println ("Name: " + name); // print out text
		System.out.println ("Sales: $" + sales);// print out text
	}

	/**
	 * method getName is for getting value of name
	 * @return name
	 */
	public String getName () // method getName
	{
		return name; //returning value of name
	}


	/**
	 * method getName is for getting value of sales
	 * @return sales
	 */
	public double getSales () //method getsales
	{
		return sales; //returning value of sales
	}
}