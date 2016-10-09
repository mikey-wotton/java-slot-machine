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
	public Symbols[] pickFiveWinners(Symbols[] array){
	    Random rnd = new Random();
		int index = rnd.nextInt(array.length+1);
		Symbols[] pickedFive = new Symbols[5];
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
	 * 35 Tens, 30 Jacks, 15 Queens, 10 Kings, 5 Aces, 5 Wilds
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */		
	public Symbols[] generateFirstWheel(){
		Symbols[] wheel = new Symbols[100];
		for(int i = 0; i < wheel.length; i++){
			 if (isBetween(i, 0, 34)) {
				wheel[i] = Symbols.TEN;
			}
		else if (isBetween(i, 35, 64 )){
				wheel[i] = Symbols.JACK;
			}
		else if (isBetween(i, 65, 79)) {
				wheel[i] = Symbols.QUEEN;
				}
		else if (isBetween(i, 80, 89)) {
				wheel[i] = Symbols.KING;
				}
		else if (isBetween(i, 90, 94)) {
				wheel[i] = Symbols.ACE;
				}	
		else if (isBetween(i, 95, 99)) {
				wheel[i] = Symbols.WILD;
				}	
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 35 Tens, 30 Jacks, 15 Queens, 10 Kings, 5 Aces, 5 Wilds
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public Symbols[] generateSecondWheel(){
		Symbols[] wheel = new Symbols[100];
		for(int i = 0; i < wheel.length; i++){
			 if (isBetween(i, 0, 34)) {
				wheel[i] = Symbols.TEN;
			}
		else if (isBetween(i, 35, 64 )){
				wheel[i] = Symbols.JACK;
			}
		else if (isBetween(i, 65, 79)) {
				wheel[i] = Symbols.QUEEN;
				}
		else if (isBetween(i, 80, 89)) {
				wheel[i] = Symbols.KING;
				}
		else if (isBetween(i, 90, 94)) {
				wheel[i] = Symbols.ACE;
				}	
		else if (isBetween(i, 95, 99)) {
				wheel[i] = Symbols.WILD;
				}		
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 35 Tens, 30 Jacks, 15 Queens, 10 Kings, 5 Aces, 5 Wilds
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public Symbols[] generateThirdWheel(){
		Symbols[] wheel = new Symbols[100];
		for(int i = 0; i < wheel.length; i++){
			 if (isBetween(i, 0, 34)) {
				wheel[i] = Symbols.TEN;
			}
		else if (isBetween(i, 35, 64 )){
				wheel[i] = Symbols.JACK;
			}
		else if (isBetween(i, 65, 79)) {
				wheel[i] = Symbols.QUEEN;
				}
		else if (isBetween(i, 80, 89)) {
				wheel[i] = Symbols.KING;
				}
		else if (isBetween(i, 90, 94)) {
				wheel[i] = Symbols.ACE;
				}	
		else if (isBetween(i, 95, 99)) {
				wheel[i] = Symbols.WILD;
				}
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 35 Tens, 30 Jacks, 15 Queens, 10 Kings, 5 Aces, 5 Wilds
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public Symbols[] generateFourthWheel(){
		Symbols[] wheel = new Symbols[100];
		for(int i = 0; i < wheel.length; i++){
			 if (isBetween(i, 0, 34)) {
				wheel[i] = Symbols.TEN;
			}
		else if (isBetween(i, 35, 64 )){
				wheel[i] = Symbols.JACK;
			}
		else if (isBetween(i, 65, 79)) {
				wheel[i] = Symbols.QUEEN;
				}
		else if (isBetween(i, 80, 89)) {
				wheel[i] = Symbols.KING;
				}
		else if (isBetween(i, 90, 94)) {
				wheel[i] = Symbols.ACE;
				}	
		else if (isBetween(i, 95, 99)) {
				wheel[i] = Symbols.WILD;
				}
		}	
		shuffleArray(wheel);
		return wheel;
	}
	/**
	 * This method should generate a single wheel with 100 variables
	 * 35 Tens, 30 Jacks, 15 Queens, 10 Kings, 5 Aces, 5 Wilds
	 * it then shuffles those variables with shuffleArray
	 * @return	shuffle array of strings
	 */	
	public Symbols[] generateFifthWheel(){
		Symbols[] wheel = new Symbols[100];
		for(int i = 0; i < wheel.length; i++){
			 if (isBetween(i, 0, 34)) {
				wheel[i] = Symbols.TEN;
			}
		else if (isBetween(i, 35, 64 )){
				wheel[i] = Symbols.JACK;
			}
		else if (isBetween(i, 65, 79)) {
				wheel[i] = Symbols.QUEEN;
				}
		else if (isBetween(i, 80, 89)) {
				wheel[i] = Symbols.KING;
				}
		else if (isBetween(i, 90, 94)) {
				wheel[i] = Symbols.ACE;
				}	
		else if (isBetween(i, 95, 99)) {
				wheel[i] = Symbols.WILD;
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
	public void shuffleArray(Symbols[] array){
	    Random rnd = new Random();

	    for (int i = array.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Symbols a = array[index];
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
	public boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x <= upper;
		}

		
}


