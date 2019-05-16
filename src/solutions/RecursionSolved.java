package solutions;


public class RecursionSolved {
   
    /**
     * Exercise 1: In this exercise you must find the sum of all the digits within a number. 
     * Example: If your number is 123 then the sum of the digits is 1 + 2 + 3 = 6.
     * NOTE: It must be solved recursively.
     * @param num - Number that is going to add.
     * @return You must return the sum of the digits of the number. 
     */
    public static int sumOfDigits(int num){ 
        if(num < 10){ // Base case
            return num; // Returns the number because it's already solved.
        }else{
            return (num % 10) + sumOfDigits(num/10);
        }         
    }
    
    /**
     * Exercise #2: In this exercise you must find the sum of all the elements of an array of integers.
     * NOTE: It must be solved recursively. You need to implement a helper function.
     * @param arr - The array of integers.
     * @return You must return the sum of all the elements of the array.
     */
    public static int sumOfElements(int[] arr){
        if(arr == null || arr.length == 0) { //Base case. 
        	return -1;
         }
		return sumOfElementsHelper(arr, 0);     
    }
    
    /*The purpose of these "helper" methods for recursion in general is exactly that: They usually have (at 
     * least) one additional parameter that somehow describes how far the recursion has already proceeded
     * or how far it still has to proceed. 
     */
    public static int sumOfElementsHelper(int[] arr, int pos){   	
    	/* Base case. If you don't do this, 
    	the recursive call will be done infinitely and 
    	will exceed the size of the array.*/
    	if(pos == arr.length-1) { 
    		return arr[pos];
    	}
    	return arr[pos] + sumOfElementsHelper(arr, pos+1);
    }
    
    /**
     * Exercise #3: In this exercise you must return the given word but the other way around.
     * NOTE: It must be solved recursively.
     * @param word - The word that is going to invert.
     * @param wordLength - The length of the word.
     * @return Returns the word backwards.
     */
    public static String invertWord(String word, int wordLength){
        if(wordLength == 0){ //Base case.
            return word.charAt(wordLength)+"";
        }else{
            return word.charAt(wordLength) + (invertWord(word, wordLength-1));
        }
         
    }
 
}

