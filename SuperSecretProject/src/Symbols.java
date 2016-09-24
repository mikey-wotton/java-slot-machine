/**
 * 
 */

/**
 * @author mikey
 *
 */
public enum Symbols {
	TEN,
	JACK,
	QUEEN,
	KING,
	ACE,
	WILD;
	public double modifier()
	{
		double modifier = 0;
		switch(this)
		{		
		case TEN:
			modifier = 1.0;
			break;
		case JACK:
			modifier = 2.0;
			break;		
		case QUEEN:
			modifier = 4.0;
			break;
		case KING:
			modifier = 20.0;
			break;
		case ACE:
			modifier = 50.0;
			break;
		case WILD:
			modifier = 50.0;
			break;
		}
		return modifier;
	}
}