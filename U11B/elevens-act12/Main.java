import java.util.Scanner;


public class Main
{
	public static void playAGame(Board board)
	{
		CardGameConsole console = new CardGameConsole(board);
		console.playGame();
	}

	public static void main(String[] args)
	{
		Scanner keyboard= new Scanner(System.in);
		System.out.print("Which game do you want to play? Enter 1 for ElevensBoard, 2 for ThirteensBoard, and 3 for TwelvesBoard: ");
		int game_number= keyboard.nextInt();
		while (game_number!=1&&game_number!=2&&game_number!=3)
		{
			System.out.print("Invalid number. Please choose again: ");
			game_number=keyboard.nextInt();
		}
		if (game_number==1)
		{
			Board board= new ElevensBoard();
			playAGame(board);
		}
		else if (game_number==2)
		{
			Board board = new ThirteensBoard();
			playAGame(board);
		}
		else if (game_number==3)
		{
			Board board = new TwelvesBoard();
			playAGame(board);
		}

	}
}
