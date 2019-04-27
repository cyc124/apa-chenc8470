//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

  //instance variables
//	private int x_Speed;
//	private int y_Speed;
  public SpeedUpBall()
  {
	super();

  }

  public SpeedUpBall(int x, int y)
  {
	super(x,y);

  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {

	super(x, y, xSpd, ySpd);
  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
	super(x,y,wid,ht, xSpd, ySpd);

  }


  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {

	super(x,y, wid, ht, col,xSpd,ySpd);


  }

  public void setXSpeed( int xSpd )
  {


	if (Math.abs(xSpd)>10)
	{
		super.setXSpeed(xSpd);
	}

	else if (xSpd<0)
	{
		xSpd = xSpd-1;
		super.setXSpeed(xSpd);
	}
	else
	{
		xSpd= xSpd+1;
		super.setXSpeed(xSpd);
	}
  }

  public void setYSpeed( int ySpd )
  {

	if (Math.abs(ySpd)>10)
	{
		super.setYSpeed(ySpd);
	}

	else if (ySpd<0)
	{
		ySpd = ySpd-1;
		super.setYSpeed(ySpd);
	}
	else
	{
		ySpd = ySpd + 1;
		super.setYSpeed(ySpd);
	}
  }

}

