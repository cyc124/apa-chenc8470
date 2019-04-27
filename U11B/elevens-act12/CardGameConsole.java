import java.util.Scanner;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.List;
public class CardGameConsole
{
	private Board board;
	public CardGameConsole(Board gameBoard)
	{
		board=gameBoard;
	}

	Scanner keyboard = new Scanner(System.in);
	public void playGame()
	{
		do
		{
			out.println("Number of cards left to deal: "+board.deckSize());
			out.println(board);
			out.print("How many cards do you want to remove in this turn? ");
			int number = keyboard.nextInt();
			List<Integer> selection= new ArrayList<Integer>();
			for (int i=0; i<number;i++)
			{
				out.print("\nEnter card index to remove: ");
				int selection_index = keyboard.nextInt();
				selection.add(selection_index);
			}

			if (board.isLegal(selection))
			{
				board.replaceSelectedCards(selection);
				if (board.isEmpty()) {
					out.println("You win!");
				} 
				else if (!board.anotherPlayIsPossible()) {
					out.println("You lose!");
					return;

				}
			}
			else	
			{
				out.print("\nSelection is not legal. Please choose again.");
			}
		} while (!board.isEmpty());
	}
}

/*		int selection1= -1;
		int selection2=-1;
		out.print("\nEnter first card index to remove");	
		selection1= keyboard.nextInt();
		out.print("\nEnter second card index to remove");
		selection2=keyboard.nextInt();
		

		List<Integer> selection = new ArrayList<Integer>();
                for (int k = 0; k < board.size(); k++) 
		{
                	if (selections[k]) 
			{
                                selection.add(new Integer(k));
                                }
                        }
 
                       // Make sure that the selected cards represent a legal replacement.
		if (!board.isLegal(selection)) {
                                signalError();
                                return;
                        }
                        for (int k = 0; k < board.size(); k++) {
                                selections[k] = false;
                        }
                        // Do the replace.
                        board.replaceSelectedCards(selection);
                        if (board.isEmpty()) {
                                signalWin();
                        } else if (!board.anotherPlayIsPossible()) {
                                signalLoss();
                        }

	
		
}
*/	
