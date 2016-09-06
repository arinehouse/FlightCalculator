/**
 * CalculatorGUI.java
 * @author arinehouse
 * Creates a Graphical User Interface to help run the FlightCalculator program
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JApplet {
	
	private final int APPLET_WIDTH = 300, APPLET_HEIGHT = 200;
	
	JTextField textField;
	JLabel timeLabel;
	JLabel errorLabel;
	
	Time totalTime = new Time (0,0,0);
	
	public void init() {
		textField = new JTextField("Enter a time in format h:mm:ss", 20);
		textField.addActionListener(new TextFieldListener());
		timeLabel = new JLabel("Total Time: " + totalTime);
		errorLabel = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(timeLabel);
		panel.add(errorLabel);
		panel.setBackground(Color.WHITE);
		
		Container cp = getContentPane();
		cp.add(panel);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	private class TextFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			errorLabel.setText("");
			String timeString = textField.getText();
			if (isValidTimeString(timeString)) {
				totalTime.add(makeTimeFromString(timeString));
				timeLabel.setText("Total Time: " + totalTime);
				repaint();
			}
			else {
				errorLabel.setText("Error: Invalid Input");
				repaint();
			}
			textField.setText("");
		}
	}
	
	// Returns true if and only if s is of the format h:mm:ss, where h is any number 
		// of digits
		private static boolean isValidTimeString(String s) {
			String[] strings = s.split(":");
			if (strings.length != 3) {
				return false;
			}
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
			
			String[] strings = s.split(":");
			int hours = Integer.parseInt(strings[0]);
			int minutes = Integer.parseInt(strings[1]);
			int seconds = Integer.parseInt(strings[2]);
			return new Time(hours, minutes, seconds);
		}
}
