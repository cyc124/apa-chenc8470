//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
                                        "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit;
  private int face;

  //constructors



	public Card()
	{
		suit = "";
		face = 0;
	}

	public Card(int f, String s)
	{
		setSuit(s);
		setFace(f);
	}

	


  // modifiers

	public void setSuit(String s)
	{
		suit = s;
	}

	public void setFace(int f)
	{
		face = f;
	}
 

  //accessors

	public String getSuit()
        {
                return suit;
        }

        public int getFace()
        {
                return face;
        }




  public abstract int getValue();

  public boolean equals(Object obj)
  {
	Card cardObj = (Card)obj;


    	return cardObj.getSuit().equals(suit)&&cardObj.getFace()==face;
  }

  public String toString()
  {
	return FACES[face]+ " of "+getSuit()+ " | value = "+ getValue();
  }
  //toString
        
}
