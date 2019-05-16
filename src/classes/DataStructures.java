package classes;

import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DataStructures {

	/**
	 * Exercise 1: Data Structures students got their final grades. Many of them unfortunately failed the course.
	 * Separate those who did passed the class from those who didn't by completing the approvedStudents() method below.
	 * NOTE: Passing grades are C and above. C starts at 65%
	 * @param section - A Queue with the Grades of the students. The Grades are composed of a Character and a Double.
	 * @return A Queue with all the approved students
	 */
	
	public Queue<Grade<Character, Double>> approvedStudents(Queue<Grade<Character, Double>> section){
		// ADD YOUR CODE HERE
		return null; // Dummy return
	}
	
	/**
	 * Exercise 2: Same as the previous exercise, but this time the method failedStudents() adds those who
	 * didn't passed the class.
	 * @param section - A Queue with the Grades of the students. The Grades are composed of a Character and a Double.
	 * @return A Queue with all the failed students
	 */
	
	public Stack<Grade<Character, Double>> failedStudents(Queue<Grade<Character, Double>> section){
		// ADD YOUR CODE HERE
		return null; // Dummy return
	}
	
	/**
	 * Exercise 3: After receiving the section grade report, the professor decided to separate them by their letter
	 * (A, B, C, D, F) and along with that, how many students got which one. Complete the resultsPerGrade() method
	 * by making the proper adjustments with the values.
	 * NOTE: Received Queue must not be mutated or, if mutated, at the end it must return to it's original state
	 * @param section - A Queue with all students Grades
	 * @return A Map containing the respective values of letter-students.
	 */
	
	public Map<Character, Integer> resultsPerGrade(Queue<Grade<Character, Double>> section) {
		// ADD YOUR CODE HERE
		return null; // Dummy return
	}

////////////////////// INTERNAL GRADE CLASS //////////////////////
	public static class Grade<Character, Double> {
		private Character letter;
		private Double percentage;
		
		public Grade(Character letter, Double percentage) {
			this.letter = letter;
			this.percentage = percentage;
		}
		
		// Setters
		public void setLetter(Character newLetter) {this.letter = newLetter;}
		public void setPercentage(Double newPercentage) {this.percentage = newPercentage;}
		
		// Getters
		public Character getLetter() {return letter;}
		public Double getPercentage() {return percentage;}
	}
}
