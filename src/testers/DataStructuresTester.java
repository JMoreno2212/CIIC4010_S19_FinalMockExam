package testers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import classes.DataStructures;
import classes.DataStructures.Grade;

public class DataStructuresTester {
	private Queue<Grade<Character, Double>> mySection1 = new LinkedList<>();
	private Queue<Grade<Character, Double>> mySection2 = new LinkedList<>();
	private Stack<Grade<Character, Double>> mySection3 = new Stack<>();
	
	@Before
	public void setUp() {
		mySection1.add(new Grade<Character, Double>('F', 52.45));
		mySection1.add(new Grade<Character, Double>('D', 61.25));
		mySection1.add(new Grade<Character, Double>('C', 65.01));
		mySection1.add(new Grade<Character, Double>('B', 83.17));
		mySection1.add(new Grade<Character, Double>('F', 54.19));
		mySection1.add(new Grade<Character, Double>('F', 41.63));
		mySection1.add(new Grade<Character, Double>('D', 64.99));
		mySection1.add(new Grade<Character, Double>('C', 72.86));
		mySection1.add(new Grade<Character, Double>('A', 94.26));
		mySection1.add(new Grade<Character, Double>('B', 87.52));
		
		mySection2.add(new Grade<Character, Double>('C', 74.17));
		mySection2.add(new Grade<Character, Double>('D', 63.15));
		mySection2.add(new Grade<Character, Double>('F', 14.07));
		mySection2.add(new Grade<Character, Double>('A', 91.76));
		mySection2.add(new Grade<Character, Double>('F', 26.98));
		mySection2.add(new Grade<Character, Double>('C', 77.52));
		mySection2.add(new Grade<Character, Double>('C', 71.43));
		mySection2.add(new Grade<Character, Double>('B', 84.28));
		mySection2.add(new Grade<Character, Double>('D', 60.38));
		mySection2.add(new Grade<Character, Double>('A', 94.70));
		
		mySection3.push(new Grade<Character, Double>('F', 17.34));
		mySection3.push(new Grade<Character, Double>('D', 62.14));
		mySection3.push(new Grade<Character, Double>('F', 57.96));
		mySection3.push(new Grade<Character, Double>('A', 95.29));
		mySection3.push(new Grade<Character, Double>('B', 86.67));
		mySection3.push(new Grade<Character, Double>('F', 24.48));
		mySection3.push(new Grade<Character, Double>('F', 37.51));
		mySection3.push(new Grade<Character, Double>('C', 79.46));
		mySection3.push(new Grade<Character, Double>('C', 78.67));
		mySection3.push(new Grade<Character, Double>('F', 53.55));
	}
	
	@Test
	public void testApprovedStudents() {
		Queue<Grade<Character, Double>> approved1 = new LinkedList<>();
		int size1 = mySection1.size();
		approved1.add(new Grade<Character, Double>('C', 65.01));
		approved1.add(new Grade<Character, Double>('B', 83.17));
		approved1.add(new Grade<Character, Double>('C', 72.86));
		approved1.add(new Grade<Character, Double>('A', 94.26));
		approved1.add(new Grade<Character, Double>('B', 87.52));
		
		assertEquals("Queue elements aren't correct", DataStructures.approvedStudents(mySection1), approved1);
		assertTrue("Elements are missing on the original Queue", size1 == mySection1.size());
		
		Queue<Grade<Character, Double>> approved2 = new LinkedList<>();
		int size2 = mySection2.size();
		approved2.add(new Grade<Character, Double>('C', 74.17));
		approved2.add(new Grade<Character, Double>('A', 91.76));
		approved2.add(new Grade<Character, Double>('C', 77.52));
		approved2.add(new Grade<Character, Double>('C', 71.43));
		approved2.add(new Grade<Character, Double>('B', 84.28));
		approved2.add(new Grade<Character, Double>('A', 94.70));
		
		assertEquals("Queue elements aren't correct", DataStructures.approvedStudents(mySection2), approved2);
		assertTrue("Elements are missing on the original Queue", size2 == mySection2.size());
	}

	@Test
	public void testFailedStudents() {
		Stack<Grade<Character, Double>> failed3 = new Stack<>();
		int size3 = mySection3.size();
		failed3.push(new Grade<Character, Double>('F', 53.55));
		failed3.push(new Grade<Character, Double>('F', 37.51));
		failed3.push(new Grade<Character, Double>('F', 24.48));
		failed3.push(new Grade<Character, Double>('F', 57.96));
		failed3.push(new Grade<Character, Double>('D', 62.14));
		failed3.push(new Grade<Character, Double>('F', 17.34));
		
		assertEquals("Stack elements aren't correct", DataStructures.failedStudents(mySection3), failed3);
		assertTrue("Elements are missing on the original Stack", size3 == mySection3.size());
	}
	
	@Test
	public void testResultsPerGrade() {
		Map<Character, Integer> grades1 = new HashMap<>();
		int size1 = mySection1.size();
		grades1.put('F', 3);
		grades1.put('D', 2);
		grades1.put('C', 2);
		grades1.put('B', 2);
		grades1.put('A', 1);
		
		assertEquals("Letter-Values aren't matching correctly", DataStructures.resultsPerGrade(mySection1), grades1);
		assertTrue("Elements are missing on the original Queue", size1 == mySection1.size());
	
		Map<Character, Integer> grades2 = new HashMap<>();
		int size2 = mySection2.size();
		grades2.put('C', 3);
		grades2.put('D', 2);
		grades2.put('F', 2);
		grades2.put('A', 2);
		grades2.put('B', 1);
		
		assertEquals("Letter-Values aren't matching correctly", DataStructures.resultsPerGrade(mySection2), grades2);
		assertTrue("Elements are missing on the original Queue", size2 == mySection2.size());
	}
}
