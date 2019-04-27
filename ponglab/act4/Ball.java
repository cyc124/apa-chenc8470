//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable 
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200,10,10);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
        

	public Ball(int x, int y)
	{
		super(x,y,10,10);
		xSpeed=3;
		ySpeed=1;
	
	}

        
	public Ball(int x, int y,int wd, int ht)
	{
		super(x,y,wd,ht);
		xSpeed=3;
		ySpeed=1;
	}

	public Ball(int x, int y, int wd, int ht, Color col)
	{
		super(x, y, wd, ht, col);
		xSpeed=3;
		ySpeed=1;
	}

	public Ball (int x, int y, int wd, int ht, Color col, int xS, int yS)
	{
		super (x, y, wd, ht, col);
		setXSpeed(xS);
		setYSpeed(yS);
	}         
        public void setXSpeed(int xS)
	{
		xSpeed=xS;
	}

	public void setYSpeed(int yS)
	{
		ySpeed=yS;
	}
        
          
  //add the set methods
   

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
	Ball one = new Ball(getX(),getY(),getHeight(),getWidth(),Color.WHITE);
	one.draw(window);

    setX(getX()+xSpeed);
    //setY
	setY(getY()+ySpeed);

	Ball two = new Ball(getX(),getY(),getHeight(),getWidth(),getColor());
	two.draw(window);
    //draw the ball at its new location
  }
   
  public boolean equals(Object obj)
  {
	if (xSpeed==((Ball)obj).getXSpeed()&&ySpeed==((Ball)obj).getYSpeed()&&getX()==((Block)obj).getX()&&getY()==((Block)obj).getY()&&getHeight()==((Block)obj).getHeight()&&getWidth()==((Block)obj).getWidth())
        {
                return true;
        }




    return false;
  }   

	public int getXSpeed()
	{
		return xSpeed;
	}

	public int getYSpeed()
	{
		return ySpeed;
	} 
  //add a toString() method  - x , y , width, height, color



	public boolean didCollideLeft(Object ob)
	{
		Block obj = (Block)ob;
		if (getX()<=obj.getX()+obj.getWidth()&&getX()+getWidth()>=obj.getX()+obj.getWidth()&&getY()+getHeight()>=obj.getY()&&getY()<=obj.getY()+obj.getHeight())
  		
		
	      	{
			if (getXSpeed()<0)
	
        	        	return true;
        	}
		return false;
	}	
	

	public boolean didCollideRight(Object ob)
	{
		Block obj = (Block)ob;
		if (getX()<=obj.getX()&&getX()+getWidth()>=obj.getX()&&getY()+getHeight()>=obj.getY()&&getY()<=obj.getY()+obj.getHeight())
		{
			if (getXSpeed()>0)
	
				return true;
		}
		return false;
	}

	public boolean didCollideBottom(Object ob)
	{
		Block obj = (Block)ob;
		if (getY()+getHeight()>=obj.getY()&&getY()<=obj.getY()&&getX()+getWidth()>=obj.getX()&&getX()<obj.getX()+obj.getWidth())
		{
			if (getYSpeed()>0)

				return true;
		}
		return false;
	}

	public boolean didCollideTop(Object ob)
	{
		Block obj = (Block) ob;
		if (getY()<obj.getY()+obj.getHeight()&&getY()+getHeight()>=obj.getY()+obj.getHeight()&&getX()+getWidth()>=obj.getX()&&getX()<obj.getX()+obj.getWidth())
		{
			if (getYSpeed()<0)
			
				return true;
		}
		return false;
	}
        public String toString()
        {
             //   return xPos+" "+yPos+" "+width+" "+height+" "+color;
       		return getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+xSpeed+" "+ySpeed;
	 }

	
  //add the get methods

  //add a toString() method
}
