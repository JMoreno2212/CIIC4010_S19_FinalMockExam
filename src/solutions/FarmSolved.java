package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class FarmSolved { // You can probably guess where the inspiration came from (Yes I used to... it was fun okay)
	private ArrayList<String> crops; // The crops produced on the farm
	private ArrayList<String> animals; // The animals being raised on the farm
	private String[] itemsForSale; // Crops and Animals that are for sale (Assume this will never be full...)
	private int money; // Amount of money in the farm
	
	public FarmSolved(ArrayList<String> crops, ArrayList<String> animals, String[] itemsForSale, int money) {
		this.crops = crops;
		this.animals = animals;
		this.itemsForSale = itemsForSale;
		this.money = money;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FarmSolved) {
			FarmSolved f = (FarmSolved) obj;
			return this.crops.equals(f.crops) && this.animals.equals(f.animals) && 
					Arrays.equals(this.itemsForSale, f.itemsForSale) && this.money == f.money;
		}	
		return false;
	}
	
	/**
	 * Exercise 1: The last baby animals that you bought are already fully grown and you decide to sell them.
	 * You won't be keeping any of this kind of animal, so adjust the lists and arrays as necessary.
	 * Hint: Remember to look for an empty spot on the itemsForSale
	 * @return The new animal for sale
	 */
	public String newAnimalForSale() {
		String lastAnimal = animals.remove(animals.size() - 1);
		for(int i = 0; i < itemsForSale.length - 1; i++) {
			if(itemsForSale[i] == null) {
				itemsForSale[i] = lastAnimal;
				break;
			}
		}
		return lastAnimal;
	}
	
	/**
	 * Exercise 2: A person arrives at your farm and says that he'll pay $20 if you can give him the crop he's 
	 * looking for and you agree to his decision. However, when he tells you the crop, you're not sure if you have
	 * it and if it's for sale or not. Make this search, update the sales and give the person the crop he wants by
	 * completing the sellCrop() method below.
	 * Hint: Find a way to ignore the null/empty spaces on the sales list
	 * @param crop - The crop requested by the man
	 * @return true if the crop is sold, false otherwise
	 */
	public boolean sellCrop(String crop) {
		for(String myCrop : crops) {
			if(myCrop.equals(crop)) {
				for(int i = 0; i < itemsForSale.length - 1; i++) {
					if(itemsForSale[i] != null && itemsForSale[i].equals(crop)) {
						itemsForSale[i] = null;
						crops.remove(myCrop);
						money += 20;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Exercise 3: Your farm needs an upgrade with new crops to grow and new animals to raise. Trying to buy an even
	 * amount of both things, you decide to buy them in pairs, until you can't afford them. This means that in order
	 * for you to buy a crop, you need to be able to afford the animal as well. Complete the upgrade() method below 
	 * to make this upgrade take place.
	 * NOTE: Each time you buy a crop, refer to it as "crop" and each time you buy an animal refer to it as "animal"
	 * @param costOfCrop - The cost of each new crop that will be bought
	 * @param costOfAnimal - The cost of each new animal that will be bought
	 * @return The amount of money left on the farm
	 */
	
	public int upgrade(int costOfCrop, int costOfAnimal) {
		while(this.getMoney() >= costOfCrop + costOfAnimal) {
				this.setMoney(this.getMoney() - costOfCrop - costOfAnimal);
				crops.add("crop");;
				animals.add("animal");		
		}	
		return this.getMoney();
	}
	
	// Getters - Although given here, you should review how to implement them yourself... (same with the Setters)
	public ArrayList<String> getCrops() {return crops;}
	public ArrayList<String> getAnimals() {return animals;}
	public String[] getItemsForSale() {return itemsForSale;}
	public int getMoney() {return money;}
	
	// Setter
	public void setMoney(int newMoney) {this.money = newMoney;}
}
