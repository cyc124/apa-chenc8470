//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    
    //call other methods
	head(window);
	upperBody(window);
	lowerBody(window);    
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);
    
	window.setColor(Color.GREEN);
	window.fillOval(350,120,20,20);
	window.fillOval(430,120,20,20);

	window.setColor(Color.BLACK);
	window.fillOval(390, 140,20,10);
	
	window.setColor(Color.RED);
	window.drawArc(350,160,100,20,0,-180);

    //add more code here
    
  }

  public void upperBody( Graphics window )
  {
	window.setColor(Color.BLUE);
	window.fillRect(350,220,100,100);
	window.setColor(Color.BLACK);
	window.drawLine(350,220,270,160);
	window.drawLine(450,220,530,160);
    //add more code here
  }

  public void lowerBody( Graphics window )
  {
	window.setColor(Color.GRAY);
	window.fillRect(350,340,100,100);
    //add more code here
	window.setColor(Color.BLACK);
	window.drawLine(350,440,270,540);
	window.drawLine(450,440,530,540);    
  }
}
