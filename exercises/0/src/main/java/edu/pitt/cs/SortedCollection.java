package edu.pitt.cs;

//TODO: Import libraries as needed
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
public class SortedCollection {
	// TODO: Add member variables or methods as needed
	private ArrayList<Integer> nums;
	public SortedCollection(){
		nums = new ArrayList<Integer>();
	}
	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(final int n) {
		// TODO: Implement
		nums.add(n);
		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		if(nums.size() == 0 ){
			throw new NoSuchElementException();
		}
		Collections.sort(nums);
		return nums.remove(0);
		
		
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(final String[] args) {
		final SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		// If any commandline argument is not a number, call showUsage() and return.
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			try{
				int num = Integer.parseInt(args[i]);
				collection.add(num);
				
			}
			catch(NumberFormatException e){
				showUsage();
				return;
			}
		}
		for (int i = 0; i < args.length; i++) {
			final int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
