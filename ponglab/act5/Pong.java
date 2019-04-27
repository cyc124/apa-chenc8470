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

//	private Ball ball;
	private BlinkyBall bBall;
//	private SpeedUpBall sBall; 
//	private InvisibleBall iBall; 

public Pong(int w, int h)
  {
    //set up all variables related to the game

	width = w;
	height = h;
	leftPaddle = new Paddle (10, 10, height/15, height/5, 5); 
	rightPaddle = new Paddle (width-50, 10, height/15, height/5, 5);

	leftWall = new Wall(0, 0, 1, height);
	rightWall = new Wall(width,0, 1, height);
	topWall = new Wall (0,0,width,1);
	bottomWall = new Wall (0, height, width, 1);

	leftScore = new Score();
	rightScore = new Score();

//	ball = new Ball(width/2,height/2);	
	bBall = new BlinkyBall(width/2,height/2);
//  	sBall = new SpeedUpBall(width/2,height/2,20,20, Color.BLUE,1,1);
//	iBall = new InvisibleBall(width/2,height/2,10,10, Color.RED, 1,1);

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

	leftPaddle.draw(window);
	rightPaddle.draw(window);
	leftWall.draw(window);
	rightWall.draw(window);
	topWall.draw(window);
	bottomWall.draw(window);
	leftScore.drawLeft(window);
	rightScore.drawRight(window);
//	ball.moveAndDraw(window);
	bBall.moveAndDraw(window);
//	sBall.moveAndDraw(window);
//	iBall.moveAndDraw(window);


//Ball
/*
	 if (ball.didCollideLeft(leftWall)||ball.didCollideRight(rightWall))
       	 {
                if (ball.didCollideRight(rightWall))
                {
                        leftScore.incrementLeftScore();

                        leftScore.drawLeft(window);
                        Ball b =new Ball(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
                        b.draw(window);
                        ball.setX(width/2);
                        ball.setY(height/2);


                }
                else if (ball.didCollideLeft(leftWall))
                {
                        rightScore.incrementRightScore();
                        rightScore.drawRight(window);
                        Ball b = new Ball(getX(), getY(), getWidth(),getHeight(),Color.WHITE);
                        b.draw(window);
                        ball.setX(width/2);
                        ball.setY(height/2);
                }
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
*/


//BlinkyBall
	if (bBall.didCollideLeft(leftWall)||bBall.didCollideRight(rightWall))
         {
                if (bBall.didCollideRight(rightWall))
                {
                        leftScore.incrementLeftScore();

                        leftScore.drawLeft(window);
                        BlinkyBall bb =new BlinkyBall(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
                        bb.draw(window);
                        bBall.setX(width/2);
                        bBall.setY(height/2);


                }
                else if (bBall.didCollideLeft(leftWall))
                {
                        rightScore.incrementRightScore();
                        rightScore.drawRight(window);
                        BlinkyBall bb = new BlinkyBall(getX(), getY(), getWidth(),getHeight(),Color.WHITE);
                        bb.draw(window);
                        bBall.setX(width/2);
                        bBall.setY(height/2);
                }
        }



        if (bBall.didCollideTop(topWall)||bBall.didCollideBottom(bottomWall))
        {
                bBall.setYSpeed(-bBall.getYSpeed());
        }




        if (bBall.didCollideLeft(leftPaddle)||bBall.didCollideRight(leftPaddle)||bBall.didCollideRight(rightPaddle)||bBall.didCollideRight(leftPaddle))
        {
                bBall.setXSpeed(-bBall.getXSpeed());
        }
        if (bBall.didCollideTop(leftPaddle)||bBall.didCollideBottom(leftPaddle)||bBall.didCollideTop(rightPaddle)||bBall.didCollideBottom(rightPaddle))
        {
                bBall.setYSpeed(-bBall.getYSpeed());
        }


//SpeedUpBall

/*
	 if (sBall.didCollideLeft(leftWall)||sBall.didCollideRight(rightWall))
        {

                if (sBall.didCollideLeft(leftWall))
                {
                        rightScore.incrementRightScore();
                        rightScore.drawRight(window);
              		SpeedUpBall sb= new SpeedUpBall(getX(), getY(), getWidth(),getHeight(),Color.WHITE,0,0);
			sb.draw(window);
			sBall.setX(width/2);
			sBall.setY(height/2);
			sBall.setXSpeed(1);
			sBall.setYSpeed(1);
		 }
                else
                {
                        leftScore.incrementLeftScore();
                        leftScore.drawLeft(window);
			SpeedUpBall sb= new SpeedUpBall(getX(), getY(), getWidth(),getHeight(),Color.WHITE,0,0);
                        sb.draw(window);
                        sBall.setX(width/2);
                        sBall.setY(height/2);
			sBall.setXSpeed(1);
			sBall.setYSpeed(1);
                }
        }



        if (sBall.didCollideTop(topWall)||sBall.didCollideBottom(bottomWall))
        {
                sBall.setYSpeed(-sBall.getYSpeed());
        }




        if (sBall.didCollideLeft(leftPaddle)||sBall.didCollideRight(leftPaddle)||sBall.didCollideRight(rightPaddle)||sBall.didCollideRight(leftPaddle))
        {
                sBall.setXSpeed(-sBall.getXSpeed());
        }
        if (sBall.didCollideTop(leftPaddle)||sBall.didCollideBottom(leftPaddle)||sBall.didCollideTop(rightPaddle)||sBall.didCollideBottom(rightPaddle))
        {
                sBall.setYSpeed(-sBall.getYSpeed());
        }
*/

//Invisible Ball
/*
	 if (iBall.didCollideLeft(leftWall)||iBall.didCollideRight(rightWall))
        {

                if (iBall.didCollideLeft(leftWall))
                {
                        rightScore.incrementRightScore();
                        rightScore.drawRight(window);
			InvisibleBall ib = new InvisibleBall(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
			ib.draw(window);
			iBall.setX(width/2);
			iBall.setY(height/2);
                }
                else
                {
                        leftScore.incrementLeftScore();
                        leftScore.drawLeft(window);
			InvisibleBall ib = new InvisibleBall(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
                        ib.draw(window);
                        iBall.setX(width/2);
                        iBall.setY(height/2);
                }
        }



        if (iBall.didCollideTop(topWall)||iBall.didCollideBottom(bottomWall))
        {
                iBall.setYSpeed(-iBall.getYSpeed());
        }




        if (iBall.didCollideLeft(leftPaddle)||iBall.didCollideRight(leftPaddle)||iBall.didCollideRight(rightPaddle)||iBall.didCollideRight(leftPaddle))
        {
                iBall.setXSpeed(-iBall.getXSpeed());
        }
        if (iBall.didCollideTop(leftPaddle)||iBall.didCollideBottom(leftPaddle)||iBall.didCollideTop(rightPaddle)||iBall.didCollideBottom(rightPaddle))
        {
                iBall.setYSpeed(-iBall.getYSpeed());
        }


	int number =(int) (Math.random()*10);
        if (number<9)
        {
		iBall.moveAndDrawInvisible(window);
	}
	else
	{
		iBall.moveAndDraw(window);
	}
*/
	
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
