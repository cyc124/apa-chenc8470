//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
	setX(100);
	setY(150);
	setWidth(10);
	setHeight(10);
	setColor(Color.BLACK);

  }

	public Block(int x,int  y,int  wd,int  ht)
        {
                setX(x);
                setY(y);
                setWidth(wd);
                setHeight(ht);
		setColor(Color.BLACK);
        }



  //add other Block constructors - x , y , width, height, color
        
  	public Block(int x,int  y,int  wd,int  ht,Color col)
	{
		setX(x);
		setY(y);		
		setWidth(wd);
		setHeight(ht);
		setColor(col);
	}

	public void setX(int x)
	{
		xPos=x;
	}
        
	public void setY(int y)
	{
		yPos=y;
	}

	public void setWidth(int wd)
	{
		width=wd;
	}

	public void setHeight(int ht)
	{
		height=ht;
	}

        
	public void setPos(int x, int y)
	{
		xPos=x;
		yPos=y;
	}        
        
        
        
  //add the other set methods
   

  public void setColor(Color col)
  {
	color=col;

  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {


  }
   
  public boolean equals(Object obj)
  {
	if (xPos==((Block)obj).getX()&&yPos==((Block)obj).getY()&&height==((Block)obj).getHeight()&&width==((Block)obj).getWidth())
	{
		return true;
	}



    return false;
  }   

  //add the other get methods
    
	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

  //add a toString() method  - x , y , width, height, color
	public String toString()
	{
		return xPos+" "+yPos+" "+width+" "+height+" "+color;
	}
}
