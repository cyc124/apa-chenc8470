import java.awt.Graphics;
public class Score 
{
	private int leftScore;
	private int rightScore;

	public Score()
	{
		leftScore = 0;
		rightScore = 0;
	}

	public void incrementLeftScore()
	{
		leftScore++;
	}

	public void incrementRightScore()
	{
		rightScore++;
	}

	public void drawLeft (Graphics window)
	{
		window.clearRect(330,420,20,10);
		window.drawString("leftScore=",250, 430);
		window.drawString(""+leftScore, 330, 430);


	}

	public void drawRight(Graphics window)
	{
		window.clearRect(330,435,20,10);
		window.drawString("rightScore=", 250, 445);
		window.drawString(""+rightScore, 330, 445);
	}
}
