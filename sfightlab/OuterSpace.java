//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
//  private Alien alienOne;
  //private Alien alienTwo;

	private Ammo ammo;
/*
   uncomment once you are ready for this part
   *
   private AlienHorde horde;
   private Bullets shots;
 */
	private List <Ammo> shotsList;
	private Bullets shots;
	private AlienHorde horde;
  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace()
  {
    setBackground(Color.black);

    keys = new boolean[5];

    //instantiate other instance variables
    //Ship, Alien
	ship = new Ship(400,300,100,100,2);
//	alienOne = new Alien(0,0,30,30,10);
//	alienTwo = new Alien(100,0,30,30,10);
	ammo = new Ammo();
	horde = new AlienHorde(50);
	shots = new Bullets();
	shotsList = shots.getList();
    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);

	ship.draw(graphToBack);
//	alienOne.draw(graphToBack);
//	alienTwo.draw(graphToBack);
	horde.drawEmAll(graphToBack);
	shots.drawEmAll(graphToBack);
	horde.moveEmAll();
//	if (keys[4]==true)
//	{
	for (int i = 0; i < shotsList.size() ; i++)
//	for (int i = shotsList.size()-1; i>=0;i--)	
	{
//	 if (shotsList.get(i).getY()!=0)
  //              {
        //                ammo.move("SHOOT");
          //              ammo.draw(graphToBack);
//			shots.moveEmAll();
//			shots.drawEmAll(graphToBack);
        		shotsList.get(i).move("SHOOT");
			shotsList.get(i).draw(graphToBack);
//			shotsList.get(i).move("SHOOT");
//			shots.cleanEmUp();
//			System.out.print(i);
//			System.out.println(shots.getList());
	

//			System.out.println(shotsList.get(i).getSpeed());
//			shots.cleanEmUp();

			for (int al = horde.getSize()-1; al >= 0 ; al--)
		        {
					if (shotsList.size()>0)
					{

	                        		Ammo a= shotsList.get(i);        
        	                		if (a.getY()<=horde.getAlien(al).getY()+horde.getAlien(al).getHeight()&&a.getY()>=horde.getAlien(al).getY()&&a.getX()>=horde.getAlien(al).getX()&&a.getX()<=horde.getAlien(al).getX()+horde.getAlien(al).getWidth())   
                	        		{
                        	        		horde.removeDeadOnes(al);
							shots.cleanEmUp(i);
						//	break;
//	                                		System.out.println("yay");              
							break;
                        			}
					}

       	 					
			}
			if (shotsList.size()>0)

				if (shotsList.get(i).getY()<0)
				{	
					shots.cleanEmUp(i);
				}
//			System.out.println();
	      }
//		}
	if (horde.getSize()==0)
	{
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Game Over! You Win!",400,300);
		
	}

	 for (int al = horde.getSize()-1; al >= 0 ; al--)
                        {
                                         if (horde.getAlien(al).getY()+horde.getAlien(al).getHeight()>=ship.getY()&&horde.getAlien(al).getX()+horde.getAlien(al).getWidth()>=ship.getX()&&horde.getAlien(al).getX()<=ship.getX()+ship.getWidth()||horde.getAlien(al).getY()+horde.getAlien(al).getHeight()>600)
                                        {
                                                        graphToBack.setColor(Color.WHITE);
                                                        graphToBack.drawString("Game Over! You Lose!",400,300);
                                                        ship.setWidth(0);
                                                        ship.setHeight(0);
                                        }
			}
	
    if(keys[0] == true)
    {
	if (ship.getX()>0)
      		ship.move("LEFT");
    }

    //add code to move Ship, Alien, etc.

	if (keys[1] == true)
	{
		if (ship.getX()+ship.getWidth()<800)
			ship.move("RIGHT");
	}

	if (keys[2] == true)
	{
		if (ship.getY()>0)

			ship.move("UP");
	}
	
	if (keys[3] == true)
	{
		if (ship.getY()+ship.getHeight()<550)
			ship.move("DOWN");
	}

	if (keys[4] ==true)
	{	
		Ammo ammo = new Ammo();	
		ammo.setX(ship.getX()+ship.getWidth()/2-ammo.getWidth()/2);
		ammo.setY(ship.getY());
		ammo.setSpeed(2);				
		shots.add(ammo);
//		shotsList.add(ammo);	
		keys[4] =false;	
	}	


    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

