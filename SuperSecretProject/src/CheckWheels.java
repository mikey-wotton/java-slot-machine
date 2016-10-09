/**
 * This class will take wheels generated by RandomiseWheels and test if they have a win line or not
 * For time being win line will mean 2 or more of the same symbols in a row anywhere on a wheel
 * 
 *  (x,x,x,x,x) = biggest win
 *  (x,x,x,x,Y) OR (Y,x,x,x,x,)= 2nd biggest win
 * 	(x,x,x,Y,W) OR (Y,x,x,x,Y) OR (Y,W,x,x,x) = third biggest win
 *  (x,x,Y,W,Z) OR (Y,x,x,Y,Z) OR (Y,Z,x,x,Y) OR (Y,W,Z,x,x) = smallest win
 * 
 */

/**
 * @author mikey
 *
 */
public class CheckWheels {
	public int twoTenMatches = 0;
	public int threeTenMatches = 0;
	public int fourTenMatches = 0;
	public int fiveTenMatches = 0;

	public int twoJackMatches = 0;
	public int threeJackMatches = 0;
	public int fourJackMatches = 0;
	public int fiveJackMatches = 0;

	public int twoQueenMatches = 0;
	public int threeQueenMatches = 0;
	public int fourQueenMatches = 0;
	public int fiveQueenMatches = 0;

	public int twoKingMatches = 0;
	public int threeKingMatches = 0;
	public int fourKingMatches = 0;
	public int fiveKingMatches = 0;

	public int twoAceMatches = 0;
	public int threeAceMatches = 0;
	public int fourAceMatches = 0;
	public int fiveAceMatches = 0;

	public int twoWildMatches = 0;
	public int threeWildMatches = 0;
	public int fourWildMatches = 0;
	public int fiveWildMatches = 0;

	/**
	 * @param args
	 */
	public void main(String[] args) {
		// TODO Auto-generated method

	}

	/**
	 * This method just keeps track of the number of matches for each symbol
	 * including the type of match, e.g 2 symbol match or 5 symbol match
	 * 
	 * @param numberOfMatches
	 *            = the number of matches made
	 * @param symbol
	 *            = the symbol that has matched, JACK/TEN etc.
	 */

	public void incrementFields(int numberOfMatches, Symbols symbol) {
		switch (symbol) {
		case TEN: {
			switch (numberOfMatches) {
			case 1:
				twoTenMatches++;
				break;
			case 2:
				threeTenMatches++;
				break;
			case 3:
				fourTenMatches++;
				break;
			case 4:
				fiveTenMatches++;
				break;
			}
			break;
		}
		case JACK: {
			switch (numberOfMatches) {
			case 1:
				twoJackMatches++;
				break;
			case 2:
				threeJackMatches++;
				break;
			case 3:
				fourJackMatches++;
				break;
			case 4:
				fiveJackMatches++;
				break;
			}
			break;
		}
		case QUEEN: {
			switch (numberOfMatches) {
			case 1:
				twoQueenMatches++;
				break;
			case 2:
				threeQueenMatches++;
				break;
			case 3:
				fourQueenMatches++;
				break;
			case 4:
				fiveQueenMatches++;
				break;
			}
			break;
		}
		case KING: {
			switch (numberOfMatches) {
			case 1:
				twoKingMatches++;
				break;
			case 2:
				threeKingMatches++;
				break;
			case 3:
				fourKingMatches++;
				break;
			case 4:
				fiveKingMatches++;
				break;
			}
			break;
		}
		case ACE: {
			switch (numberOfMatches) {
			case 1:
				twoAceMatches++;
				break;
			case 2:
				threeAceMatches++;
				break;
			case 3:
				fourAceMatches++;
				break;
			case 4:
				fiveAceMatches++;
				break;
			}
			break;
		}
		case WILD: {
			switch (numberOfMatches) {
			case 1:
				twoWildMatches++;
				break;
			case 2:
				threeWildMatches++;
				break;
			case 3:
				fourWildMatches++;
				break;
			case 4:
				fiveWildMatches++;
				break;
			}
			break;
		}
		}
	}

	public double checkWheels(Symbols[][] wheels, int numberOfPayLines) {
		double value = 0;
		int numberOfMatches = 0;
		double modifier = 0;
		switch (numberOfPayLines) {
		case 1:
			value = -1;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 2:
			value = -2;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 3:
			value = -3;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 4:
			value = -4;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 5:
			value = -5;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 6:
			value = -6;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches *modifier);
			}
			break;
		case 7:
			value = -7;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches *modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 8:
			value = -8;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches *modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}
			break;
		case 9:
			value = -9;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches *modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}
			// ___
			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][2]);			
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			break;
		case 10:
			value = -10;
			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][3], wheels[3][2], wheels[4][1]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][3], wheels[1][2],	wheels[2][1], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][3], wheels[1][2], wheels[2][1], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][3]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches *modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3], wheels[2][2], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][3],	wheels[2][3], wheels[3][3], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}
			// ___
			numberOfMatches = numberOfMatchesOnLine(wheels[0][2], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][2]);			
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][2], wheels[1][1],	wheels[2][1], wheels[3][1], wheels[4][2]);
				incrementFields(numberOfMatches, wheels[0][2]);
				value = value + (numberOfMatches * modifier);
			}

			numberOfMatches = numberOfMatchesOnLine(wheels[0][1], wheels[1][2],	wheels[2][2], wheels[3][2], wheels[4][3]);
			if (numberOfMatches != 0) {
				modifier = getModifier(wheels[0][1], wheels[1][2], wheels[2][2], wheels[3][2], wheels[4][3]);
				incrementFields(numberOfMatches, wheels[0][1]);
				value = value + (numberOfMatches * modifier);
			}
			break;

		}

		// checks for symbol matching quantities

		return value;
	}

	public int numberOfMatchesOnLine(Symbols i, Symbols j, Symbols k,
			Symbols l, Symbols m) {
		Symbols[] array = new Symbols[5];
		array[0] = i;
		array[1] = j;
		array[2] = k;
		array[3] = l;
		array[4] = m;
		Symbols temp = null;
		for (int z = 0; z < array.length; z++) {
			if ((temp == null) && array[z] != Symbols.WILD) {
				temp = array[z];
			}
		}
		if (temp == null) {
			return 4;
		}
		if (i == Symbols.WILD) {
			if (j == temp || j == Symbols.WILD) {
				if (k == temp || k == Symbols.WILD) {
					if (l == temp || l == Symbols.WILD) {
						if (m == temp || m == Symbols.WILD) {
							return 4;
						}
						return 3;
					}
					return 2;
				}
				return 1;
			}
		} else {
			if ((i == j) || (j == Symbols.WILD)) {
				if ((j == k) || (k == Symbols.WILD) || (k == temp)) {
					if ((k == l) || (l == Symbols.WILD) || (l == temp)) {
						if ((l == m) || (m == Symbols.WILD) || (m == temp)) {
							return 4;
						}
						return 3;
					}
					return 2;
				}
				return 1;
			}
		}
		return 0;
	}

	public double getModifier(Symbols i, Symbols j, Symbols k, Symbols l, Symbols m) {
		Symbols[] array = new Symbols[5];
		array[0] = i;
		array[1] = j;
		array[2] = k;
		array[3] = l;
		array[4] = m;
		Symbols temp = null;
		for (int z = 0; z < array.length; z++) {
			if ((temp == null) && array[z] != Symbols.WILD) {
				temp = array[z];
			}
		}
		if(temp != null){
			return temp.modifier();
		}
		return i.modifier();
	}

	public int getTwoTenMatches() {
		return twoTenMatches;
	}

	public int getThreeTenMatches() {
		return threeTenMatches;
	}

	public int getFourTenMatches() {
		return fourTenMatches;
	}

	public int getFiveTenMatches() {
		return fiveTenMatches;
	}

	public int getTwoJackMatches() {
		return twoJackMatches;
	}

	public int getThreeJackMatches() {
		return threeJackMatches;
	}

	public int getFourJackMatches() {
		return fourJackMatches;
	}

	public int getFiveJackMatches() {
		return fiveJackMatches;
	}

	public int getTwoQueenMatches() {
		return twoQueenMatches;
	}

	public int getThreeQueenMatches() {
		return threeQueenMatches;
	}

	public int getFourQueenMatches() {
		return fourQueenMatches;
	}

	public int getFiveQueenMatches() {
		return fiveQueenMatches;
	}

	public int getTwoKingMatches() {
		return twoKingMatches;
	}

	public int getThreeKingMatches() {
		return threeKingMatches;
	}

	public int getFourKingMatches() {
		return fourKingMatches;
	}

	public int getFiveKingMatches() {
		return fiveKingMatches;
	}

	public int getTwoAceMatches() {
		return twoAceMatches;
	}

	public int getThreeAceMatches() {
		return threeAceMatches;
	}

	public int getFourAceMatches() {
		return fourAceMatches;
	}

	public int getFiveAceMatches() {
		return fiveAceMatches;
	}
}
