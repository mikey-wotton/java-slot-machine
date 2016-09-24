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
	RandomiseWheels randomiseWheels;
	CheckWheels checkWheels;
	static int num = 1;
	RandomiseWheels randomWheel = new RandomiseWheels();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomiseWheels randomiseWheels = new RandomiseWheels();
		CheckWheels checkWheels = new CheckWheels();

		int spin = 0;
		double k = 0;
		double totalWinOrLoss = 0;
		int[][] arrayOfWheels = new int[5][5];
		while(k < 3000000){

		arrayOfWheels[0] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFirstWheel());
		arrayOfWheels[1] = randomiseWheels.pickFiveWinners(randomiseWheels.generateSecondWheel());
		arrayOfWheels[2] = randomiseWheels.pickFiveWinners(randomiseWheels.generateThirdWheel());
		arrayOfWheels[3] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFourthWheel());
		arrayOfWheels[4] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFifthWheel());
			totalWinOrLoss +=checkWheels.checkWheels(arrayOfWheels, num);
			System.out.println("Spins:" + spin + " - WinOrLoss: " + ((num *3000000) / ((num *3000000) - totalWinOrLoss) )*100+"%");
			k++;
			spin++;
		}
		System.out.println("Win Lines: "+num);
		System.out.println("Ten Matches (Modifier:"+checkWheels.getTenModifier()+"):"+checkWheels.TwoTenMatches+"    : "+checkWheels.ThreeTenMatches+"   : "+checkWheels.FourTenMatches+"   : " +checkWheels.FiveTenMatches);
		System.out.println("Jack Matches (Modifier:"+checkWheels.getJackModifier()+"):"+checkWheels.TwoJackMatches+"   : "+checkWheels.ThreeJackMatches+"  : "+checkWheels.FourJackMatches+"  : " +checkWheels.FiveJackMatches);
		System.out.println("Queen Matches (Modifier:"+checkWheels.getQueenModifier()+"):"+checkWheels.TwoQueenMatches+"  : "+checkWheels.ThreeQueenMatches+" : "+checkWheels.FourQueenMatches+" : " +checkWheels.FiveQueenMatches);
		System.out.println("King Matches (Modifier:"+checkWheels.getKingModifier()+"):"+checkWheels.TwoKingMatches+"   : "+checkWheels.ThreeKingMatches+"  : "+checkWheels.FourKingMatches+"  : " +checkWheels.FiveKingMatches);
		System.out.println("Ace Matches (Modifier:"+checkWheels.getAceModifier()+"):"+checkWheels.TwoAceMatches+"    : "+checkWheels.ThreeAceMatches+"   : "+checkWheels.FourAceMatches+"   : " +checkWheels.FiveAceMatches);
		
	}
		
}
