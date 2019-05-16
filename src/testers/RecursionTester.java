package testers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import classes.Recursion;

public class RecursionTester {
	int[] sumArray, sumArray2, sumArray3, sumArray4;
	
	@Before
	public void setUp() {
		sumArray = new int[] {9,100,8765,40,30};
		sumArray2 = new int[] {0,0,0,0,0,0};
		sumArray3 = new int[] {};
		sumArray4 = null;
	}
	
	@Test
	 public void sumOfDigitsTest() {
		
		assertFalse("It is returning 0", Recursion.sumOfDigits(123) == 0);
		assertFalse("It is returning the same number", Recursion.sumOfDigits(784) == 784);
		assertTrue(Recursion.sumOfDigits(123) == 6);
		assertTrue(Recursion.sumOfDigits(5091) == 15);
		assertTrue(Recursion.sumOfDigits(9876543) == 42);
		assertTrue(Recursion.sumOfDigits(1) == 1);
		
	}
	@Test
	 public void sumOfElementsTest() {
		
		assertFalse("You are returning 0", Recursion.sumOfElements(sumArray) == 0);
		assertNotNull("You are returning null", Recursion.sumOfElements(sumArray));
		assertNotNull("Null array must return -1.", Recursion.sumOfElements(sumArray4));
		assertTrue(Recursion.sumOfElements(sumArray4) == -1 && Recursion.sumOfElements(sumArray3) == -1);
		assertTrue(Recursion.sumOfElements(sumArray) == 8944);
		assertTrue(Recursion.sumOfElements(sumArray2) == 0);
		
	}
	String word = "Voy a pasar el semestre";
	@Test
	 public void invertWord() {
		
		assertNotNull( "You are returning null", Recursion.invertWord("Amo", 2));
		assertNotEquals("You are returning an empty String.", "", Recursion.invertWord("Programar", 8));
		assertNotEquals("You are returning the word as it was", "Saco A+ en Java", Recursion.invertWord("Saco A+ en Java", 14));
		assertEquals("aloH", Recursion.invertWord("Hola", 3));
		assertEquals("ananaB", Recursion.invertWord("Banana", 5));
		assertEquals("ertsemes le rasap a yoV", Recursion.invertWord(word, word.length()-1));
		
	}

}
