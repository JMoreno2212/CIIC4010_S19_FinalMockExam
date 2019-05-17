package testers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import classes.Farm;

public class FarmTester {
	private Farm farm1, farm2, farm3, farm4;
	private ArrayList<String> crops1, crops2, crops3, crops4;
	private ArrayList<String> animals1, animals2, animals3, animals4;
	private String[] itemsForSale1, itemsForSale2, itemsForSale3, itemsForSale4;

	@Before
	public void setUp() {
		crops1 = new ArrayList<String>(Arrays.asList("corn", "sugar", "wheat", "cotton"));
		crops2 = new ArrayList<String>(Arrays.asList("lettuce", "carrots", "tomatoes"));
		crops3 = new ArrayList<String>(Arrays.asList("apples", "pears", "grapes"));
		crops4 = new ArrayList<String>(Arrays.asList("peas", "coffee", "beans"));
		
		animals1 = new ArrayList<String>(Arrays.asList("cows", "pigs", "chickens"));
		animals2 = new ArrayList<String>(Arrays.asList("rabbits", "sheeps", "goats"));
		animals3 = new ArrayList<String>(Arrays.asList("horses", "llamas", "donkeys"));
		animals4 = new ArrayList<String>(Arrays.asList("ducks", "rooster", "turkey"));
		
		itemsForSale1 = new String[] {"wheat", "sugar", "cows", null, null};
		itemsForSale2 = new String[] {"carrots", "rabbits", "goats", null, null};
		itemsForSale3 = new String[] {"apples", "pears", "grapes", null, null};
		itemsForSale4 = new String[] {"coffee", "rooster", "turkey", null, null};

		farm1 = new Farm(crops1, animals1, itemsForSale1, 100);
		farm2 = new Farm(crops2, animals2, itemsForSale2, 500);
		farm3 = new Farm(crops3, animals3, itemsForSale3, 250);
		farm4 = new Farm(crops4, animals4, itemsForSale4, 275);
	}
	
	@Test
	public void testNewAnimalForSale() {
		ArrayList<String> animalsUpdated1 = new ArrayList<>(Arrays.asList("cows", "pigs"));
		String[] newItemsForSale1 = new String[] {"wheat", "sugar", "cows", "chickens", null};
		Farm addedAnimalForSale1 = new Farm(crops1, animalsUpdated1, newItemsForSale1, 100);
		String animalForSale1 = farm1.newAnimalForSale();
		assertEquals("Farm animals weren't properly updated", farm1.getAnimals(), addedAnimalForSale1.getAnimals());
		assertTrue("Farm items for sale weren't properly updated", Arrays.equals(farm1.getItemsForSale(), addedAnimalForSale1.getItemsForSale()));
		assertTrue("Farms aren't the same", farm1.equals(addedAnimalForSale1));
		assertTrue("You're not selling the right animal", animalForSale1.equals("chickens"));
	}
	
	@Test
	public void testSellCrop() {
		boolean wasSold2 = farm2.sellCrop("carrots");
		String[] newItemsForSale2 = new String[] {null, "rabbits", "goats", null, null};
		Farm soldCrop2 = new Farm(crops2, animals2, newItemsForSale2, 520);
		assertTrue("The item was not sold", wasSold2);
		assertEquals("Selling the carrots, doesn't mean you will stop producing them", farm2.getCrops(), soldCrop2.getCrops());
		assertTrue("Money wasn't updated properly", farm2.getMoney() == soldCrop2.getMoney());
		assertTrue("Farms aren't the same", farm2.equals(soldCrop2));
		
		boolean wasSold3 = farm3.sellCrop("oranges");
		assertFalse("The requested crop is not being produced on the farm", wasSold3);
		
		boolean wasSold4 = farm4.sellCrop("peas");
		assertFalse("Just because it's being produced, doesn't mean it's on sale", wasSold4);
	}
	
	@Test
	public void testUpgrade() {
		int moneyLeft3 = farm3.upgrade(20, 50);
		ArrayList<String> upgradedCrops3 = new ArrayList<String>(Arrays.asList("apples", "pears", "grapes", "crop", "crop", "crop"));
		ArrayList<String> upgradedAnimals3 = new ArrayList<String>(Arrays.asList("horses", "llamas", "donkeys", "animal", "animal", "animal"));
		Farm upgraded3 = new Farm(upgradedCrops3, upgradedAnimals3, itemsForSale3, 40);
		assertEquals("The amount of new crops is not correct", farm3.getCrops(), upgraded3.getCrops());
		assertEquals("Thea mount of new animals is not the same", farm3.getAnimals(), upgraded3.getAnimals());
		assertTrue("The amount of money remaining is not correct", farm3.getMoney() == moneyLeft3);
		assertTrue(farm3.equals(upgraded3));
		
		int moneyLeft4 = farm4.upgrade(40, 80);
		ArrayList<String> upgradedCrops4 = new ArrayList<String>(Arrays.asList("peas", "coffee", "beans", "crop", "crop"));
		ArrayList<String> upgradedAnimals4 = new ArrayList<String>(Arrays.asList("ducks", "rooster", "turkey", "animal", "animal"));
		Farm upgraded4 = new Farm(upgradedCrops4, upgradedAnimals4, itemsForSale4, 35);
		assertEquals("The amount of new crops is not correct", farm4.getCrops(), upgraded4.getCrops());
		assertEquals("Thea mount of new animals is not the same", farm4.getAnimals(), upgraded4.getAnimals());
		assertTrue("The amount of money remaining is not correct", farm4.getMoney() == moneyLeft4);
		assertTrue(farm4.equals(upgraded4));
	}
}
