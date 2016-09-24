/**
 * 
 * This machine will simulate a slot machine, for simplicity sake I will refer to a wheel as having 5 points
 * The wheel will represented by an array of string, this is to make printing out the array as I go easier; I'll probably swap to char later on
 * Each point is a String representing a value, A for Ace, K for King, Q for Queen, J to Jack, and finally T for Ten.
 * so a wheel could look like (A,K,T,T,K) for example
 * 
 * RandomiseWheels will generate random points and place them on a wheel
 * 
 * TBA: class will look at generated wheels and check for win lines
 * TBA: class will on win lines being generated announce a payout
 * TBA: class will keep track of wins, spins and total losses/earnings 
 * 
 * 
 * 
 */

/**
 * @author mikey
 *
 */
public class Main {
	static int num = 1;
	RandomiseWheels randomWheel = new RandomiseWheels();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int spin = 0;
		double k = 0;
		double totalWinOrLoss = 0;
		int[][] arrayOfWheels = new int[5][5];
		while(k < 3000000){

		arrayOfWheels[0] = RandomiseWheels.pickFiveWinners(RandomiseWheels.generateFirstWheel());
		arrayOfWheels[1] = RandomiseWheels.pickFiveWinners(RandomiseWheels.generateSecondWheel());
		arrayOfWheels[2] = RandomiseWheels.pickFiveWinners(RandomiseWheels.generateThirdWheel());
		arrayOfWheels[3] = RandomiseWheels.pickFiveWinners(RandomiseWheels.generateFourthWheel());
		arrayOfWheels[4] = RandomiseWheels.pickFiveWinners(RandomiseWheels.generateFifthWheel());
			totalWinOrLoss +=CheckWheels.checkWheels(arrayOfWheels, num);
			System.out.println("Spins:" + spin + " - WinOrLoss: " + ((num *3000000) / ((num *3000000) - totalWinOrLoss) )*100+"%");
			k++;
			spin++;
		}
		System.out.println("Win Lines: "+num);
		System.out.println("Ten Matches (Modifier:"+CheckWheels.getTenModifier()+"):"+CheckWheels.TwoTenMatches+"    : "+CheckWheels.ThreeTenMatches+"   : "+CheckWheels.FourTenMatches+"   : " +CheckWheels.FiveTenMatches);
		System.out.println("Jack Matches (Modifier:"+CheckWheels.getJackModifier()+"):"+CheckWheels.TwoJackMatches+"   : "+CheckWheels.ThreeJackMatches+"  : "+CheckWheels.FourJackMatches+"  : " +CheckWheels.FiveJackMatches);
		System.out.println("Queen Matches (Modifier:"+CheckWheels.getQueenModifier()+"):"+CheckWheels.TwoQueenMatches+"  : "+CheckWheels.ThreeQueenMatches+" : "+CheckWheels.FourQueenMatches+" : " +CheckWheels.FiveQueenMatches);
		System.out.println("King Matches (Modifier:"+CheckWheels.getKingModifier()+"):"+CheckWheels.TwoKingMatches+"   : "+CheckWheels.ThreeKingMatches+"  : "+CheckWheels.FourKingMatches+"  : " +CheckWheels.FiveKingMatches);
		System.out.println("Ace Matches (Modifier:"+CheckWheels.getAceModifier()+"):"+CheckWheels.TwoAceMatches+"    : "+CheckWheels.ThreeAceMatches+"   : "+CheckWheels.FourAceMatches+"   : " +CheckWheels.FiveAceMatches);
		
	}
		
}
