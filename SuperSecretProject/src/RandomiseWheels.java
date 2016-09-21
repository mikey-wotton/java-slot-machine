/**
 * This class will handle generating random wheels, with 5 random points on that wheel.
 * NOTE: probably gonna end up swapping the random strings to enum at some point in the future
 * 
 */

/**
 * @author mikey
 *
 */
import java.util.Random;

public class RandomiseWheels {	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//used for testing this class alone
		//RandomiseWheels randomisedWheel = new RandomiseWheels();
	}
	
	/**
	 * This method should choose 5 consecutive symbols from a "wheel"
	 * which are then displayed to the user and checked for wins against other wheels
	 * 
	 */
	public static int[] pickFiveWinners(int[] array){
	    Random rnd = new Random();
		int index = rnd.nextInt(array.length+1);
		int[] pickedFive = new int[5];
		for(int i = 0; i < pickedFive.length; i++ ){
			if(index == 100){
				index = 0;				
			}
			pickedFive[i] = array[index];
			index++;
		}
		
		return pickedFive;		
	}	
	
	/**
	 * This method should generate a single wheel with 100 variables
	 * 40 Tens, 30 Jacks, 20 Queens, 7 Kings, 3 Aces
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */		
	public static int[] generateFirstWheel(){
		int[] wheel = new int[100];
		for(int i = 0; i < wheel.length; i++){
			if (isBetween(i, 0, 39)) {
					wheel[i] = 0;
				}
			else if (isBetween(i, 40, 69 )) {
					wheel[i] = 1;
				}
			else if (isBetween(i, 70, 89)) {
					wheel[i] = 2;
					}
			else if (isBetween(i, 90, 96)) {
					wheel[i] = 3;
					}
			else if (isBetween(i, 97, 99)) {
					wheel[i] = 4;
					}				
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 40 Tens, 30 Jacks, 20 Queens, 7 Kings, 3 Aces
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public static int[] generateSecondWheel(){
		int[] wheel = new int[100];
		for(int i = 0; i < wheel.length; i++){
			if (isBetween(i, 0, 39)) {
					wheel[i] = 0;
				}
			else if (isBetween(i, 40, 69 )) {
					wheel[i] = 1;
				}
			else if (isBetween(i, 70, 89)) {
					wheel[i] = 2;
					}
			else if (isBetween(i, 90, 96)) {
					wheel[i] = 3;
					}
			else if (isBetween(i, 97, 99)) {
					wheel[i] = 4;
					}				
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 40 Tens, 30 Jacks, 20 Queens, 7 Kings, 3 Aces
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public static int[] generateThirdWheel(){
		int[] wheel = new int[100];
		for(int i = 0; i < wheel.length; i++){
			if (isBetween(i, 0, 39)) {
					wheel[i] = 0;
				}
			else if (isBetween(i, 40, 69 )) {
					wheel[i] = 1;
				}
			else if (isBetween(i, 70, 89)) {
					wheel[i] = 2;
					}
			else if (isBetween(i, 90, 96)) {
					wheel[i] = 3;
					}
			else if (isBetween(i, 97, 99)) {
					wheel[i] = 4;
					}				
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 40 Tens, 30 Jacks, 20 Queens, 7 Kings, 3 Aces
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public static int[] generateFourthWheel(){
		int[] wheel = new int[100];
		for(int i = 0; i < wheel.length; i++){
			if (isBetween(i, 0, 39)) {
					wheel[i] = 0;
				}
			else if (isBetween(i, 40, 69 )) {
					wheel[i] = 1;
				}
			else if (isBetween(i, 70, 89)) {
					wheel[i] = 2;
					}
			else if (isBetween(i, 90, 96)) {
					wheel[i] = 3;
					}
			else if (isBetween(i, 97, 99)) {
					wheel[i] = 4;
					}				
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 40 Tens, 30 Jacks, 20 Queens, 7 Kings, 3 Aces
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public static int[] generateFifthWheel(){
		int[] wheel = new int[100];
		for(int i = 0; i < wheel.length; i++){
			if (isBetween(i, 0, 39)) {
					wheel[i] = 0;
				}
			else if (isBetween(i, 40, 69 )) {
					wheel[i] = 1;
				}
			else if (isBetween(i, 70, 89)) {
					wheel[i] = 2;
					}
			else if (isBetween(i, 90, 96)) {
					wheel[i] = 3;
					}
			else if (isBetween(i, 97, 99)) {
					wheel[i] = 4;
					}				
		}	
		shuffleArray(wheel);
		return wheel;
	}
		
	/** Fisher Yates shuffle
	 * This method shuffles the generated array 100 times, to provide some randomness to the wheel
	 * i.e you don't see T in a row 25 times, or at least its incredibly unlikely
	 * 
	 * @param array the array to be shuffled
	 */
	public static void shuffleArray(int[] array){
	    Random rnd = new Random();

	    for (int i = array.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = array[index];
	      array[index] = array[i];
	      array[i] = a;
	    }
	  }
	
	
	/**
	 * method used to test if number is between 2 inclusive numbers
	 * @param x - the number to be tested
	 * @param lower = the lower bound, inclusive
	 * @param upper = the upper bound, inclusive
	 */
	public static boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x <= upper;
		}

		
}


