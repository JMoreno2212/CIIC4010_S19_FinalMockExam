package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DataStructuresSolved {

	/**
	 * Exercise 1: Data Structures students got their final grades. Many of them unfortunately failed the course.
	 * Separate those who did passed the class from those who didn't by completing the approvedStudents() method below.
	 * NOTE: Received Queue must not be mutated or, if mutated, at the end it must return to it's original state
	 * NOTE: Passing grades are C and above. C starts at 65%
	 * @param section - A Queue with the Grades of the students. The Grades are composed of a Character and a Double.
	 * @return A Queue with all the approved students
	 */
	
	public static Queue<Grade<Character, Double>> approvedStudents(Queue<Grade<Character, Double>> section){
		int originalSize = section.size(); // This allows us to iterate over every element just once
		Queue<Grade<Character, Double>> result = new LinkedList<>(); // LinkedList are simple when working with Queues
		for(int i = 0; i < originalSize; i++) {
			Grade<Character,Double> g = section.poll(); // Take out the one to be examined
			if(g.getPercentage() >= 65) { // if Pass, add it to the list
				result.add(g);
			}
			section.add(g); // Add once again the one you took away
		}
		
		return result;
	}
	
	/**
	 * Exercise 2: Same as the previous exercise, but this time the method failedStudents() adds those who
	 * didn't passed the class.
	 * NOTE: Received Stack must not be mutated or, if mutated, at the end it must return to it's original state
	 * @param section - A Stack with the Grades of the students. The Grades are composed of a Character and a Double.
	 * @return A Stack with all the failed students
	 */
	
	public static Stack<Grade<Character, Double>> failedStudents(Stack<Grade<Character, Double>> section){
		int originalSize = section.size(); // Again, iterate over every element just once
		Stack<Grade<Character, Double>> result = new Stack<>();
		Stack<Grade<Character,Double>>  temp = new Stack<>();
		for(int i = 0; i < originalSize; i++) {
			Grade<Character,Double> g = section.pop();
			if(g.getPercentage() < 65.00) {
				result.push(g);
			}
			temp.push(g);
		}
		
		while(!temp.isEmpty()) {
			section.push(temp.pop());
		}
		return result;
	}
	
	/**
	 * Exercise 3: After receiving the section grade report, the professor decided to separate them by their letter
	 * (A, B, C, D, F) and along with that, how many students got which one. Complete the resultsPerGrade() method
	 * by making the proper adjustments with the values.
	 * NOTE: Received Queue must not be mutated or, if mutated, at the end it must return to it's original state
	 * @param section - A Queue with all students Grades
	 * @return A Map containing the respective values of letter-students.
	 */
	
	public static Map<Character, Integer> resultsPerGrade(Queue<Grade<Character, Double>> section) {
		int originalSize = section.size();
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for(int i = 0; i < originalSize; i++) {
			Grade<Character, Double> g = section.poll();
			if(result.containsKey(g.getLetter())) {
				result.put(g.getLetter(), result.get(g.getLetter()) + 1);
				//result.replace(g.getLetter(), result.get(g.getLetter()) + 1);
			}
			else result.put(g.getLetter(), 1);
			section.add(g);
		}
		
		return result;
	}

////////////////////// INTERNAL GRADE CLASS //////////////////////
	@SuppressWarnings("hiding")
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
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Grade<?, ?>) {
				Grade<?,?> grade = (Grade<?,?>) obj;
				return this.letter.equals(grade.getLetter()) && this.percentage.equals(grade.getPercentage());
			}
			return false;
		}
	}
}
