/**
 * Time.java
 * @author arinehouse
 * A unit of time delineated by hours, minutes, and seconds.
 * Hours are any number of digits, while minutes and seconds are two digits long
 */
public class Time {
	
	// Class variables
	private int hours, minutes, seconds;
	
	// Creates an instance of a Time object
	public Time(int hr, int min, int sec) {
		if (hr < 0 || min < 0 || sec < 0){
			System.err.println("Error: Invalid input.");
			return;
		}
		
		hours = hr;
		
		if (min < 60) {
			minutes = min;
		}
		else {
			int extraHours = min / 60;
			minutes = min % 60;
			hours += extraHours;
		}
		
		if (sec < 60) {
			seconds = sec;
		}
		else {
			int extraMinutes = sec / 60;
			seconds = sec % 60;
			minutes += extraMinutes;
		}
	}
	
	// Returns a time object that is the sum of this and t
	public void add(Time t) {
		int resultHours = 0, resultMinutes = 0, resultSeconds = 0;
		int extraMinutes = 0, extraHours = 0;
		
		// Add up the seconds, and then add these onto minutes if needed
		int totalSeconds = this.getSeconds() + t.getSeconds();
		if (totalSeconds < 60) {
			resultSeconds = totalSeconds;
		}
		else {
			extraMinutes = totalSeconds / 60;
			resultSeconds = totalSeconds % 60;
		}
		
		// Add up the minutes, and then add these onto minutes if needed
		int totalMinutes = this.getMinutes() + t.getMinutes() + extraMinutes;
		if (totalMinutes < 60) {
			resultMinutes = totalMinutes;
		}
		else {
			extraHours = totalMinutes / 60;
			resultMinutes = (totalMinutes % 60);
		}
		
		// Add up the hours
		resultHours = this.getHours() + t.getHours() + extraHours;
		
		this.hours = resultHours;
		this.minutes = resultMinutes;
		this.seconds = resultSeconds;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	// Returns the Time as a String, and pads zeroes as necessary
	public String toString() {
		if (minutes / 10 > 0 && seconds / 10 > 0) {
			return hours + ":" + minutes + ":" + seconds;
		}
		else if (minutes / 10 == 0 && seconds / 10 == 0) {
			return hours + ":0" + minutes + ":0" + seconds;
		}
		else if (minutes / 10 == 0) {
			return hours + ":0" + minutes + ":" + seconds;
		}
		else {
			return hours + ":" + minutes + ":0" + seconds;
		}
	}
}
