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
	AccountDetails userDetails;
	RandomiseWheels randomiseWheels = new RandomiseWheels();
	CheckWheels checkWheels = new CheckWheels();
	Symbols[][] arrayOfWheels;
	int[] bonusFlagArray;
	double winOrLoseAmount;
	double totalStake;
	double totalWon;

	static int num = 10;
	static int stake = 1;
	/**
	 * @param args
	 */
	static public void main(String[] args) {
		Main main = new Main("john", 1000.0);
		main.testMillSpins();

	}
	public Main(String username, double balance){
		bonusFlagArray = new int[10];
		arrayOfWheels = new Symbols[5][5];
		userDetails = new AccountDetails("",0);
		userDetails.setUsername(username);
		userDetails.setBalance(balance);
	}
	public void spinOnce(int numberOfLinesPlayed, double stakePerLine){
			arrayOfWheels[0] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFirstWheel());
			arrayOfWheels[1] = randomiseWheels.pickFiveWinners(randomiseWheels.generateSecondWheel());
			arrayOfWheels[2] = randomiseWheels.pickFiveWinners(randomiseWheels.generateThirdWheel());
			arrayOfWheels[3] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFourthWheel());
			arrayOfWheels[4] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFifthWheel());
			
			
			
			totalStake = numberOfLinesPlayed * stakePerLine;		
			totalWon = ((checkWheels.checkWheels(arrayOfWheels, numberOfLinesPlayed) * stakePerLine));
			bonusFlagArray[0] = checkWheels.checkBonus(arrayOfWheels);
			double OverallTotalInOut = totalWon - totalStake;
			
			userDetails.updateBalance(OverallTotalInOut);
			if(OverallTotalInOut > 0){
				winOrLoseAmount = totalWon;
			}
			else if(OverallTotalInOut == 0){
				winOrLoseAmount = 0;
			}
			else{
				winOrLoseAmount = OverallTotalInOut;
			}
			System.out.println(userDetails.getUsername() + ": "+userDetails.getBalance());
		}
	
	
	
	
	
	public void testMillSpins(){
		int spin = 0;
		double k = 0;
		double totalWonOrLost = 0;
		Symbols[][] arrayOfWheels = new Symbols[5][5];
		while(k < 1000000){
		arrayOfWheels[0] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFirstWheel());
		arrayOfWheels[1] = randomiseWheels.pickFiveWinners(randomiseWheels.generateSecondWheel());
		arrayOfWheels[2] = randomiseWheels.pickFiveWinners(randomiseWheels.generateThirdWheel());
		arrayOfWheels[3] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFourthWheel());
		arrayOfWheels[4] = randomiseWheels.pickFiveWinners(randomiseWheels.generateFifthWheel());
			userDetails.updateBalance(checkWheels.checkWheels(arrayOfWheels, num) - (num * stake));
			totalWonOrLost +=checkWheels.checkWheels(arrayOfWheels, num) - (num * stake);
			System.out.println("Spins:" + spin + " - WinOrLoss: " + (((num * stake) * 1000000000) / (((num * stake) * 1000000000) - totalWonOrLost) )*100+"%");
			k++;
			spin++;
		}
		//Used for reporting the wins at the end of run
		System.out.println("Win Lines: "+num);
		System.out.println("Stake per line: "+stake);
		System.out.println("User Balance: "+userDetails.getBalance());
		System.out.println("Ten Matches (Modifier:"+Symbols.TEN.modifier()+"):"+checkWheels.getTwoTenMatches()+"    : "+checkWheels.getThreeTenMatches()+"   : "+checkWheels.getFourTenMatches()+"   : " +checkWheels.getFiveTenMatches());
		System.out.println("Jack Matches (Modifier:"+Symbols.JACK.modifier()+"):"+checkWheels.getTwoJackMatches()+"   : "+checkWheels.getThreeJackMatches()+"  : "+checkWheels.getFourJackMatches()+"  : " +checkWheels.getFiveJackMatches());
		System.out.println("Queen Matches (Modifier:"+Symbols.QUEEN.modifier()+"):"+checkWheels.getTwoQueenMatches()+"  : "+checkWheels.getThreeQueenMatches()+" : "+checkWheels.getFourQueenMatches()+" : " +checkWheels.getFiveQueenMatches());
		System.out.println("King Matches (Modifier:"+Symbols.KING.modifier()+"):"+checkWheels.getTwoKingMatches()+"   : "+checkWheels.getThreeKingMatches()+"  : "+checkWheels.getFourKingMatches()+"  : " +checkWheels.getFiveKingMatches());
		System.out.println("Ace Matches (Modifier:"+Symbols.ACE.modifier()+"):"+checkWheels.getTwoAceMatches()+"    : "+checkWheels.getThreeAceMatches()+"   : "+checkWheels.getFourAceMatches()+"   : " +checkWheels.getFiveAceMatches());
	}
	
	public String getWinOrLoseString(double amount){
		if(amount > (totalStake * 50)){
			return "Huge win of £"+amount+"! Congratulations";
		}
		else if(amount > (totalStake * 20)){
			return "Huge win of £"+amount+"! Congratulations";
		}
		else if(amount > (totalStake * 10)){
			return "Big win of £"+amount+"! Well done!";
		}
		else if(amount > (totalStake * 5)){
			return "Win of £"+amount+"! Well done!";
		}
		else if(amount > 0){
			return "Small win of £"+amount+"! Every penny helps!";
		}
		else {
			return "No win this time! Try again!";
		}
	}
	
	public int[] getWinLineArray(){
		return checkWheels.getWinLinesArray();
	}
	
	public double getWinOrLoseAmount(){
		return winOrLoseAmount;
	}
	public double getTotalWon(){
		return totalWon;
	}
		
}
