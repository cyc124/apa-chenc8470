//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  //add in Player instance variable
  //add in Dealer instance variable
	private Dealer dealer;
	private Player player;
	private int dealerWins;
	private int playerWins;
  public BlackJack()
  {
	dealer = new Dealer();
	player = new Player();
	dealerWins=0;
	playerWins=0;

  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice = 0;
	dealer.shuffle();
	do
	{
		player.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
	//	System.out.println(player);
		out.println("\nPLAYER ");
    		out.println("Hand Value :: " + player.getHandValue() );
    		out.println("Hand Size :: " + player.getHandSize() );
    		out.println("Cards in Hand :: " + player.toString() );
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

		if (dealer.getHandValue()>21 && player.getHandValue()>21)
		{
			System.out.println("Both players bust!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
			System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else if(dealer.getHandValue()>21)
		{
			playerWins++;
			player.setWinCount(playerWins);
			System.out.println("Player wins - Dealer busted!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else if(player.getHandValue()>21)
		{
			dealerWins++;
			dealer.setWinCount(dealerWins);
			System.out.println("Dealer wins - Player busted!");
			System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        System.out.println("Player has won "+player.getWinCount()+" times.");
		}
		else
		{
			if ( player.getHandValue()>dealer.getHandValue())
			{
				playerWins++;
				player.setWinCount(playerWins);
				System.out.println("Player has a bigger hand value!");
				System.out.println("Dealer has won "+dealer.getWinCount()+" times.");
                        	System.out.println("Player has won "+player.getWinCount()+" times.");
			}	

			else if (player.getHandValue()<dealer.getHandValue())
			{
				dealerWins++;
				dealer.setWinCount(dealerWins);
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
		dealer.resetHand();
		player.resetHand();
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
