/**
 * FlightCalculator.java
 * @author arinehouse
 * Allows a user to input flight times and calculate the total travel time of a flight
 */

import java.util.Scanner;

public class FlightCalculator {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		String input = "";
		
		Time totalTime = new Time (0,0,0);
		
		
		System.out.println("Please enter a time in format h:mm:ss, or enter q to quit:");
		input = console.nextLine();
		while (!input.equalsIgnoreCase("q")) {
			totalTime.add(makeTimeFromString(input));
			System.out.println("Time so far is " + totalTime);
			System.out.println("Please enter another time in format h:mm:ss, "
					+ "or enter q to quit:");
			input = console.nextLine();
		}
		System.out.println("Quit successful. Total flight time is " + totalTime);
	}
	
	// Returns true if and only if s is of the format h:mm:ss, where h is any number 
	// of digits
	private static boolean isValidTimeString(String s) {
		String[] strings = s.split(":");
		int hours = Integer.parseInt(strings[0]);
		int minutes = Integer.parseInt(strings[1]);
		int seconds = Integer.parseInt(strings[2]);
		
		if (hours < 0 || minutes < 0 || seconds < 0)
			return false;
		else if (strings[1].length() != 2)
			return false;
		else if (strings[2].length() != 2)
			return false;
		else
			return true;
	}
	
	// Returns a time variable from a given string in a valid Time string format
	// If it is not in this format, returns an error
	private static Time makeTimeFromString(String s) {
		if (!isValidTimeString(s)) {
			System.err.println("Error: Invalid format.");
			return null;
		}
		else {
			String[] strings = s.split(":");
			int hours = Integer.parseInt(strings[0]);
			int minutes = Integer.parseInt(strings[1]);
			int seconds = Integer.parseInt(strings[2]);
			return new Time(hours, minutes, seconds);
		}
	}
}
