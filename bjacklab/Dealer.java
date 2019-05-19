//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer
{
        
        
        
        
//instance variable - Deck 

	private Deck deck;



//constructors
	public Dealer()
	{
		super();
		deck = new Deck();
	}




//method to shuffle

	public void shuffle()
	{
		deck.shuffle();
	}




//method to deal a card

	public Card deal()
	{
		return deck.nextCard();
	}


	public boolean hit()
	{
		
		return getHandValue()<16;
	}
}
//hit method goes here
