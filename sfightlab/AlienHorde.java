//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;

  public AlienHorde(int size)
  {
	int x = 0;
	int y = 0;
	aliens = new ArrayList <Alien>();
		for (int i = 0; i<size; i++)
		{
			Alien alien = new Alien (x, y,30,30,1);
			add(alien);
			if (x < 770)
				x+=30;
			else
			{
				y+=30;
				x=0;
			}
		}
		
  }

  public void add(Alien al)
  {
	aliens.add(al);
  }

  public int  getSize()
  {
	return aliens.size();
  }

  public Alien getAlien(int i)
  {
	return aliens.get(i);
  }
  public void drawEmAll( Graphics window )
  {
	for (int i = 0; i < aliens.size();i++)
	{
		aliens.get(i).draw(window);
	}

  }

  public void moveEmAll()
  {
	for (int i = 0; i < aliens.size(); i++)
	{
		aliens.get(i).move("NEXT");
	} 
  }

  //public void removeDeadOnes(List<Ammo> shots)
  public void removeDeadOnes(int i)
  {

	/*
	for (int al = aliens.size()-1; al >= 0 ; al++)
	{
		for (int i = 0; i < shots.size();i++)
		{
			System.out.println(shots.get(i));
			Ammo ammo= shots.get(i);	
			if (ammo.getX()>=aliens.get(al).getX()&&ammo.getX()<=aliens.get(al).getX()+aliens.get(al).getWidth())	
			{
				aliens.remove(al);
				System.out.println("yay");		
			}
		}
	}
*/
	aliens.remove(i);
  }

  public String toString()
  {
    return "";
  }
}
