//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }


  //add the other Paddle constructors


	public Paddle(int x, int y)
	{
		super(x,y);
		speed = 5;
	}

	public Paddle(int x, int y, int s)
	{
		super(x,y);
		speed = s;
	}

	public Paddle(int x, int y, int wd, int ht, int s)
	{
		super(x, y, wd, ht);
		speed = s;
	}


	public Paddle (int x, int y, int wd, int ht, Color col, int s)
	{
		super(x, y, wd, ht, col);
		speed = s;
	}
	







  public void moveUpAndDraw(Graphics window)
  {
	Paddle one = new Paddle(getX(),getY(),getWidth(),getHeight(),Color.WHITE,speed);
	one.draw(window);
	super.setY(getY()-speed);

	Paddle two= new Paddle(getX(), getY(), getWidth(), getHeight(),getColor(),speed);
	two.draw(window);

  }

  public void moveDownAndDraw(Graphics window)
  {
	Paddle one = new Paddle(getX(),getY(),getWidth(),getHeight(),Color.WHITE,speed);
        one.draw(window);
        super.setY(getY()+speed);

        Paddle two= new Paddle(getX(), getY(), getWidth(), getHeight(),getColor(),speed);
        two.draw(window);

  }

  //add get methods
   public int getSpeed()
	{
		return speed;	
	}

   
	public String toString()
	{
		return super.toString()+" "+ speed;
	}
  //add a toString() method
}
