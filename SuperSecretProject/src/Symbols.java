import java.net.URL;

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
	WILD,
	BONUS;
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
			modifier = 8.0;
			break;
		case ACE:
			modifier = 16.0;
			break;
		case WILD:
			modifier = Symbols.ACE.modifier();
			break;
		case BONUS:
			modifier = 0.0;
			break;
		}
		return modifier;
	}
	public String imageString(){
		String imageLocation = "";
		switch(this)
		{		
		case TEN:
			imageLocation = "black_ten.png";
			break;
		case JACK:
			imageLocation = "orange_jack.png";
			break;		
		case QUEEN:
			imageLocation ="lgrey_queen.png";
			break;
		case KING:
			imageLocation ="grey_king.png";
			break;
		case ACE:
			imageLocation = "kl_ace.png";
			break;
		case WILD:
			imageLocation = "gold_wild.png";
			break;
		case BONUS:
			imageLocation = "bonus_symbol.png";
			break;
		}
		return "res\\symbols\\"+imageLocation;
	}
	public URL getURL(){
		URL url = null;
		switch(this)
		{		
		case TEN:
			url  = GUI.class.getResource("symbols\\black_ten.png");
			break;
		case JACK:
			url = GUI.class.getResource("symbols\\orange_jack.png");
			break;		
		case QUEEN:
			url = GUI.class.getResource("symbols\\lgrey_queen.png");
			break;
		case KING:
			url = GUI.class.getResource("symbols\\grey_king.png");
			break;
		case ACE:
			url = GUI.class.getResource("symbols\\kl_ace.png");
			break;
		case WILD:
			url = GUI.class.getResource("symbols\\gold_wild.png");
			break;
		case BONUS:
			url = GUI.class.getResource("symbols\\bonus_symbol.png");
			break;
		}
		return url;
	}
}