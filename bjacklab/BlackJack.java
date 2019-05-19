//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
public class BlackJack
{
  //add in Player instance variable
  //add in Dealer instance variable
//	private Dealer dealer;
//	private Player player;
//	private int dealerWins;
//	private int playerWins;
	private ArrayList<Playerable> players;
  public BlackJack()
  {
//	dealer = new Dealer();
//	player = new Player();
//	dealerWins=0;
//	playerWins=0;
	players = new ArrayList<Playerable>();

  }

  public void playGame()
  {
	System.out.println("How many players? (Enter integer >= 1)");
	Scanner keyboard = new Scanner(System.in);
	int numberOfPlayers = keyboard.nextInt();
	Dealer dealer = new Dealer();
	players.add(dealer);
	for (int i = 0; i < numberOfPlayers; i++)
	{
		Player player = new Player();
		players.add(player);
	}
    char choice = 0;
	dealer.shuffle();
	do
	{
	//	player.addCardToHand(dealer.deal());
	//	player.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
	//	System.out.println(player);
		for (int i = 1; i < players.size();i++)
		{

			Player player =(Player) players.get(i);
			player.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());
			out.println("\nPLAYER "+ i);
			out.println("Hand Value :: " + player.getHandValue() );
			out.println("Hand Size :: " + player.getHandSize() );
			out.println("Cards in Hand :: " + player.toString() );
			if (player.getHandValue()<21)
			{
				System.out.println("Do you want to hit? [y/n]");
				choice = keyboard.next().charAt(0);
				while (choice=='y' && player.getHandValue()<21)
				{
					player.addCardToHand(dealer.deal());
				//	out.println("\nPLAYER ");
					out.println("Hand Value :: " + player.getHandValue() );
					out.println("Hand Size :: " + player.getHandSize() );
					out.println("Cards in Hand :: " + player.toString() );
					if (player.getHandValue()<21)
					{
						System.out.println("Do you want to hit? [y/n]");
						choice = keyboard.next().charAt(0);

					}
				}
			}
		}
	//	System.out.println(dealer);

		out.println("\nDEALER ");
    		out.println("Hand Value :: " + dealer.getHandValue() );
    		out.println("Hand Size :: " + dealer.getHandSize() );
    		out.println("Cards in Hand :: " + dealer.toString() );
		while (dealer.hit())
		{
			dealer.addCardToHand(dealer.deal());
		//	out.println("\nDEALER ");
	                out.println("Hand Value :: " + dealer.getHandValue() );
        	        out.println("Hand Size :: " + dealer.getHandSize() );
               	 out.println("Cards in Hand :: " + dealer.toString() );

		}

		int winningNumber = 0;
		for (int i = 0; i <players.size(); i++)
		{
			int handValue = players.get(i).getHandValue();
			if (handValue<=21 && handValue>winningNumber)
			{
				winningNumber = handValue;
			}
		
		}
		System.out.println("\n");
		
		if (winningNumber == 0)
                {
                        System.out.println("Everyone busted!");
                }
		for (int j = 0; j < players.size();j++)
		{
			if (players.get(j).getHandValue()==winningNumber)
			{
				players.get(j).setWinCount(players.get(j).getWinCount()+1);
				if (j == 0)
				{
					System.out.println("Dealer wins!");
				}
				else
				{
					System.out.println("Player " + j+ " wins!");
				}
			}
		}
		System.out.println("Dealer has won "+ dealer.getWinCount()+" times.");
		for (int k = 1; k<players.size();k++)
		{
			System.out.println("Player "+k+ " has won "+players.get(k).getWinCount()+" times.");
		}/*
		if (dealer.getHandValue()>21 && player.getHandValue()>21)
		{
			System.out.println("Both players bust!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
			System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else if(dealer.getHandValue()>21)
		{
			
			player.setWinCount(player.getWinCount()+1);
			System.out.println("Player wins - Dealer busted!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else if(player.getHandValue()>21)
		{
			
			dealer.setWinCount(dealer.getWinCount()+1);
			System.out.println("Dealer wins - Player busted!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else
		{
			if ( player.getHandValue()>dealer.getHandValue())
			{
				
				player.setWinCount(player.getWinCount()+1);
				System.out.println("Player has a bigger hand value!");
				System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        	System.out.println("Player has won "+player.getWinCount()+" times.");
			}	

			else if (player.getHandValue()<dealer.getHandValue())
			{
				
				dealer.setWinCount(dealer.getWinCount()+1);
				System.out.println("Dealer has a bigger hand value!");
                                System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                                System.out.println("Player has won "+player.getWinCount()+" times.");
			}
			else
			{
				System.out.println("Tie!");
                                System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                                System.out.println("Player has won "+player.getWinCount()+" times.");
			}
		}
		*/
		dealer.resetHand();
		for (int h = 1; h<players.size();h++)
		{
			players.get(h).resetHand();
		}
		dealer.shuffle();
		System.out.println("Do you want to play again? [y/n]");
		choice = keyboard.next().charAt(0);
	}while (choice=='y');
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}
