/**
 * 
 */

/**
 * @author mikey
 *
 */
import java.util.Random;

public class RandomiseWheels {

	
	Random random = new Random();
	String[] wheel = new String[5];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomiseWheels randomisedWheel = new RandomiseWheels();
		randomisedWheel.generateWheel();
	}
	
	public String[] generateWheel(){
		for(int i = 0; i < wheel.length; i++){
			wheel[i] = generateSingle();
		}
			
		return wheel;
	}
	/**
	 * This method generates a single point on a 5 wheel
	 * @return
	 */
	public String generateSingle(){
		String Character="";
		switch(random.nextInt(6))
		{
		case 0:
			Character = "A";
			break;
		case 1:
			Character = "K";
			break;
		case 2:
			Character = "Q";
			break;
		case 3:
			Character = "J";
			break;
		case 4:
			Character = "T";
			break;
		case 5:
			Character = "N";
			break;
		}		
		return Character;
	}
	
	
	
	
}


