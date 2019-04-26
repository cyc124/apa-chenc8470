//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block
{
  //instance variables

  public Wall()
  {
    super(10,10);
  }




	public Wall(int x, int y)
	{
		super(x,y);
	}


	public Wall(int x, int y, int wd, int ht)
	{
		super(x, y, wd, ht);
	}


  //add get methods

   
	public String toString()
	{
		return super.toString();
	}
  //add a toString() method
}
