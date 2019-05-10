//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;
	private Image image;
  public Ammo()
  {
    this(0,0,1);
  }

  public Ammo(int x, int y)
  {
    //add code
	super(x,y);
	speed = 0;
  }

  public Ammo(int x, int y, int s)
  {
    //add code
	super(x,y);
	speed = s;
	try
	{
      		URL url = getClass().getResource("ammo.jpg");
      		image = ImageIO.read(url);
    	}
    	catch(Exception e)
    	{
      //feel free to do something here
   	}

  }

  public void setSpeed(int s)
  {
    //add code
	speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void draw( Graphics window )
  {
    //add code to draw the ammo
	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	
//	window.drawImage(image, getX(), getY(), getWidth(),getHeight(), null);
		
  }
        
        
  public void move( String direction )
  {
    //add code to draw the ammo
        if (direction.equals("SHOOT"))
        {
                setY(getY()-speed);
        }
	
  }

  public String toString()
  {
    return "ammo - speed: "+speed;
  }
}
