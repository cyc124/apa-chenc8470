//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

	private ArrayList<Card> tempStackOfCards;
  public Deck ()
  {
    //initialize data - stackOfCards - topCardIndex
	
	stackOfCards = new ArrayList<Card>();                
    //loop through suits
    //loop through faces
    //add in a new card
	for (int suits = 0; suits < NUMSUITS; suits ++)
	{
		for (int faces = 1; faces < NUMFACES+1; faces++)
		{
			Card newCard = new BlackJackCard (faces, SUITS[suits]);
			stackOfCards.add(newCard);
		}
	}
	topCardIndex = stackOfCards.size();
                
  }

  //modifiers
  public void shuffle ()
  {
    //shuffle the deck
    //reset variables as needed
	tempStackOfCards = new ArrayList<Card>();
	while (stackOfCards.size()>0)
	{
		int random = (int)(Math.random()*stackOfCards.size());
		tempStackOfCards.add(stackOfCards.get(random));
		stackOfCards.remove(random);
	}
	for (int i = 0; i < tempStackOfCards.size();i++)
	{
		stackOfCards.add(tempStackOfCards.get(i));
	}
	
	topCardIndex = stackOfCards.size();
  }

  //accessors
  public int size ()
  {
    return stackOfCards.size();
  }

  public int numCardsLeft()
  {
    return topCardIndex;
  }

  public Card nextCard()
  {
	topCardIndex--;
    return stackOfCards.get(topCardIndex);
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}
