//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);
		
		Shape one = new Shape(50,50,100,200,Color.RED);
		one.draw(window);

		Shape two = new Shape(200,250, 200,100, Color.YELLOW);
		two.draw(window);

		Shape three = new Shape(400,400,100,150,Color.BLUE);
		three.draw(window);


		Shape four = new Shape(350, 100, 100, 50, Color.GREEN);
		four.draw(window);
		//instantiate a Shape
		//tell your shape to draw

		//instantiate a Shape
		//tell your shape to draw

		//instantiate a Shape
		//tell your shape to draw
	}
}
