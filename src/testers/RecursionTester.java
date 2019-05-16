package testers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Recursion;

class RecursionTester {

	@Test
	 public void sumOfDigitsTest() {
		
		assertFalse(Recursion.sumOfDigits(123) == 0, "You are returning 0.");
		assertFalse(Recursion.sumOfDigits(784) == 784, "It is not the correct result. You are returning the same number.");
		assertTrue(Recursion.sumOfDigits(123) == 6);
		assertTrue(Recursion.sumOfDigits(5091) == 15);
		assertTrue(Recursion.sumOfDigits(9876543) == 42);
		assertTrue(Recursion.sumOfDigits(1) == 1);
		
	}
	
	int[] sumArray = {9,100,8765,40,30};
	int[] sumArray2 = {0,0,0,0,0,0};
	int[] sumArray3 = {};
	int[] sumArray4 = null;
	@Test
	 public void sumOfElementsTest() {
		
		assertFalse(Recursion.sumOfElements(sumArray) == 0, "You are returning 0.");
		assertNotEquals(null, Recursion.sumOfElements(sumArray), "You are returning null.");
		assertNotEquals(null, Recursion.sumOfElements(sumArray4), "You are returning null. You must return -1.");
		assertTrue(Recursion.sumOfElements(sumArray4) == -1 && Recursion.sumOfElements(sumArray3) == -1);
		assertTrue(Recursion.sumOfElements(sumArray) == 8944);
		assertTrue(Recursion.sumOfElements(sumArray2) == 0);
		
	}
	String word = "Voy a pasar el semestre";
	@Test
	 public void invertWord() {
		
		assertNotEquals(null, Recursion.invertWord("Amo", 2), "You are returning null.");
		assertNotEquals("", Recursion.invertWord("Programar", 8), "You are returning an empty String.");
		assertNotEquals("Saco A+ en Java", Recursion.invertWord("Saco A+ en Java", 14), "You are returning the word as it was.");
		assertEquals("aloH", Recursion.invertWord("Hola", 3));
		assertEquals("ananaB", Recursion.invertWord("Banana", 5));
		assertEquals("ertsemes le rasap a yoV", Recursion.invertWord(word, word.length()-1));
		
	}

}
