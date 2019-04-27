//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class InvisibleBall extends Ball
{

  //constructors
  public InvisibleBall()
  {
    super();
  }

  public InvisibleBall(int x, int y)
  {
	super(x,y);


  }

  public InvisibleBall(int x, int y, int wid, int ht)
  {
	super(x,y,wid,ht);


  }

  public InvisibleBall(int x, int y, int wid, int ht, Color col)
	{
		super(x, y, wid, ht, col);
	}	

  public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {

	super(x,y,wid,ht,xSpd,ySpd);

  }

  public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
	super(x,y,wid,ht,col,xSpd,ySpd);



  }
/*
  public Color randomColor()
  {
    int r =(int)(Math.random()*256);          //use Math.random()
    int g = (int)(Math.random()*256);
    int b = (int)(Math.random()*256);
    return new Color(r,g,b);
  }
*/
  public void moveAndDraw(Graphics window)
  {
	InvisibleBall one = new InvisibleBall(getX(),getY(),getHeight(),getWidth(),Color.WHITE);
        one.draw(window);

	setX(getX()+getXSpeed());
    //setY
        setY(getY()+getYSpeed());
/*
	int number =(int) (Math.random()*10);
	if (number<8)
	{
		for (int i = 0; i<= 20; i++)
		{
		
			InvisibleBall inv = new InvisibleBall(getX(), getY(),getHeight(), getWidth(), Color.WHITE);
			inv.draw(window);
//			setX(getX()+getXSpeed());
//			setY(getY()+getYSpeed());
		}
	}
  */    InvisibleBall two = new InvisibleBall(getX(),getY(),getHeight(),getWidth(),getColor());
        two.draw(window);
	
	

  }

	public void moveAndDrawInvisible(Graphics window)
	{
		InvisibleBall one = new InvisibleBall(getX(), getY(), getHeight(),getWidth(), Color.WHITE);
		one.draw(window);
		setX(getX()+getXSpeed());
		setY(getY()+getYSpeed());
		InvisibleBall two = new InvisibleBall(getX(),getY(),getHeight(),getWidth(),Color.WHITE);
		two.draw(window);
	}
}
