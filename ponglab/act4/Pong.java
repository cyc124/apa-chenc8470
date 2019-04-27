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
import java.lang.Math;
public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;


	private Wall leftWall;
	private Wall rightWall;
	private Wall topWall;
	private Wall bottomWall;

	private Score leftScore;
	private Score rightScore;

	private int width;
	private int height;
  public Pong(int w, int h)
  {
    //set up all variables related to the game

	width = w;
	height = h;
	ball = new Ball();
	leftPaddle = new Paddle (10, 10, height/15, height/5, 5); 
	rightPaddle = new Paddle (width-50, 10, height/15, height/5, 5);

	leftWall = new Wall(0, 0, 1, height);
	rightWall = new Wall(width,0, 1, height);
	topWall = new Wall (0,0,width,1);
	bottomWall = new Wall (0, height, width, 1);

	leftScore = new Score();
	rightScore = new Score();	
    keys = new boolean[4];


    
    setBackground(Color.WHITE);
    setVisible(true);
                
    new Thread(this).start();
    addKeyListener(this);               //starts the key thread to log key strokes
  }
        
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    Graphics2D twoDGraph = (Graphics2D)window;

	ball.moveAndDraw(window);
	leftPaddle.draw(window);
	rightPaddle.draw(window);
	leftWall.draw(window);
	rightWall.draw(window);
	topWall.draw(window);
	bottomWall.draw(window);
	leftScore.drawLeft(window);
	rightScore.drawRight(window);

  	if (ball.didCollideLeft(leftWall)||ball.didCollideRight(rightWall))
	{
      	//	ball.setXSpeed(-ball.getXSpeed());
		if (ball.didCollideRight(rightWall))
		{
			leftScore.incrementLeftScore();
			
			leftScore.drawLeft(window);
			Ball b =new Ball(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
			b.draw(window);
			ball.setX(200);
			ball.setY(200);
			
			
		}
		else if (ball.didCollideLeft(leftWall))
		{
			rightScore.incrementRightScore();
			rightScore.drawRight(window);
			Ball b = new Ball(getX(), getY(), getWidth(),getHeight(),Color.WHITE);
			b.draw(window);
			ball.setX(200);
			ball.setY(200);
		}
//		ball.setXSpeed(-ball.getXSpeed());
    	}

                

	if (ball.didCollideTop(topWall)||ball.didCollideBottom(bottomWall))
	{
		ball.setYSpeed(-ball.getYSpeed());	
	}




	if (ball.didCollideLeft(leftPaddle)||ball.didCollideRight(leftPaddle)||ball.didCollideRight(rightPaddle)||ball.didCollideRight(leftPaddle))
	{
		ball.setXSpeed(-ball.getXSpeed());
	}
	if (ball.didCollideTop(leftPaddle)||ball.didCollideBottom(leftPaddle)||ball.didCollideTop(rightPaddle)||ball.didCollideBottom(rightPaddle))
	{
		ball.setYSpeed(-ball.getYSpeed());
	}

    if (keys[0])
    {
      if (leftPaddle.getY()-leftPaddle.getSpeed()>=0)
                leftPaddle.moveUpAndDraw(window);

    }

    if (keys[1])
    {
      //move left paddle down and draw it on the window
        if (leftPaddle.getY()+leftPaddle.getHeight()<=height-1)
                leftPaddle.moveDownAndDraw(window);

    }
    if (keys[2])
    {
        if (rightPaddle.getY()-leftPaddle.getSpeed()>=0)
                rightPaddle.moveUpAndDraw(window);
    }
    if (keys[3])
    {
        if (rightPaddle.getY()+rightPaddle.getHeight()<=height-1)

                rightPaddle.moveDownAndDraw(window);
    }

                
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(8);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }     
}
