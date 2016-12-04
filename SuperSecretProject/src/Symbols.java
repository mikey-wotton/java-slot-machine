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
			modifier = 8.0;
			break;
		case ACE:
			modifier = 16.0;
			break;
		case WILD:
			modifier = Symbols.ACE.modifier();
			break;
		}
		return modifier;
	}
	public String imageString(){
		String imageLocation = "";
		switch(this)
		{		
		case TEN:
			imageLocation = "ten_small.jpg";
			break;
		case JACK:
			imageLocation = "jack_small.jpg";
			break;		
		case QUEEN:
			imageLocation ="queen_small.jpg";
			break;
		case KING:
			imageLocation ="king_small.jpg";
			break;
		case ACE:
			imageLocation = "ace_small.jpg";
			break;
		case WILD:
			imageLocation = "wild_small.jpg";
			break;
		}
		return "res\\symbols\\"+imageLocation;
	}
	public URL getURL(){
		URL url = null;
		switch(this)
		{		
		case TEN:
			url  = Main.class.getResource("symbols\\ten_small.jpg");
			break;
		case JACK:
			url = Main.class.getResource("symbols\\jack_small.jpg");
			break;		
		case QUEEN:
			url = Main.class.getResource("symbols\\queen_small.jpg");
			break;
		case KING:
			url = Main.class.getResource("symbols\\king_small.jpg");
			break;
		case ACE:
			url = Main.class.getResource("symbols\\ace_small.jpg");
			break;
		case WILD:
			url = Main.class.getResource("symbols\\wild_small.jpg");
			break;
		}
		return url;
	}
}