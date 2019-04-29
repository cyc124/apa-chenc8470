import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel [] rowArray: pixels)
		{
			for (Pixel pixelObj: rowArray)
			{
			//	if (pixelObj.getColor()!=Color.BLUE)
 			//	{
					pixelObj.setRed(0);
					pixelObj.setGreen(0);
			//	}
			}
		}
	}


	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel [] rowArray:pixels)
		{
			for (Pixel pixelObj: rowArray)
			{
				pixelObj.setRed(255-pixelObj.getRed());
				pixelObj.setGreen(255- pixelObj.getGreen());
				pixelObj.setBlue(255- pixelObj.getBlue());
			}
		}
	}

	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray:pixels)
		{
			for (Pixel pixelObj: rowArray)
			{
				pixelObj.setRed((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
				pixelObj.setGreen((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
				pixelObj.setBlue((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
			}
		}
	}

	public void grayscaleAverage()
	{
		Pixel[][] pixels = this.getPixels2D();
                for (Pixel [] rowArray:pixels)
                {
                        for (Pixel pixelObj: rowArray)
                        {
                                pixelObj.setGrayAverage(pixelObj.getColor());
                        }
                }
        }

	public void grayscaleLightness()
	{
		Pixel[][] pixels = this.getPixels2D();
                for (Pixel [] rowArray:pixels)
                {
                        for (Pixel pixelObj: rowArray)
                        {       
                                pixelObj.setGrayLightness(pixelObj.getColor());
                        }
                }
        }

	public void grayscaleLuminosity()
	{
		Pixel[][] pixels = this.getPixels2D();
                for (Pixel [] rowArray:pixels)
                {
                        for (Pixel pixelObj: rowArray)
                        {
                                pixelObj.setGrayLuminosity(pixelObj.getColor());
                        }
                }
        }

		
	public void fixUnderwater()
	{
		Pixel [][] pixels = this.getPixels2D();
		for (Pixel[] rowArray:pixels)
		{
			for (Pixel pixelObj: rowArray)
			{
		//		if (pixelObj.getRed()<20)
		//		{
		//			pixelObj.setRed(255);
		//		}
				pixelObj.setGreen(255- pixelObj.getGreen());
                                pixelObj.setBlue(255- pixelObj.getBlue());
			}
		}
	}
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

	public void mirrorVerticalRightToLeft()
	{
	Pixel[][] pixels = this.getPixels2D();
	Pixel leftPixel = null;
	Pixel rightPixel = null;
	int width = pixels[0].length;
	for (int row = 0; row < pixels.length; row++)
    	{
		for (int col = 0; col < width / 2; col++)
		{
        		leftPixel = pixels[row][col];
        		rightPixel = pixels[row][width - 1 - col];
        		leftPixel.setColor(rightPixel.getColor());
      		}
    	}
  	}	
	
	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
    		Pixel bottomPixel = null;
		int width = pixels[0].length;
    		int height = pixels.length;
    		for (int col = 0; col < width; col++)
    		{
      			for (int row= 0; row<pixels.length;row++)
      			{
        			topPixel = pixels[row][col];
        			bottomPixel = pixels[height-1-row][col];
        			bottomPixel.setColor(topPixel.getColor());
      			}		
    		}
  	}
  
	public void mirrorHorizontalBotToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
                Pixel topPixel = null;
                Pixel bottomPixel = null;
                int width = pixels[0].length;
                int height = pixels.length;
                for (int col = 0; col < width; col++)
                {
                        for (int row= 0; row<pixels.length;row++)
                        {
                                topPixel = pixels[row][col];
                                bottomPixel = pixels[height-1-row][col];
                                topPixel.setColor(bottomPixel.getColor());
                        }
                }
        }


	
	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
                Pixel topRightPixel = null;
                Pixel bottomLeftPixel = null;
                int width = pixels[0].length;
                int height = pixels.length;
		int m = Math.min(width, height);
		for (int row= 0; row<m;row++)
                {
                	for (int col = 0; col < row; col++)
                        {
			
				{
						bottomLeftPixel = pixels[row][col];
						topRightPixel = pixels[col][row];
					
					topRightPixel.setColor(bottomLeftPixel.getColor());
	                      //          topRightPixel = pixels[row][m-col-1];
                                //	bottomLeftPixel = pixels[m-1-row][col];
				
                                //	topRightPixel.setColor(bottomLeftPixel.getColor());
				}
				
                        }
                }
        }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
	count++;
      }
    }
	System.out.println(count);
  }


	public void mirrorArms()
	{
		Pixel [][]pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		for (int row = 159; row<193; row++)
		{
			for (int col = 120; col<170; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel =pixels [193-row+193][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
		for (int row = 174; row < 195; row++)
		{
			for (int col = 239; col<290; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel =pixels[193-row+193][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull()
	{
		int mirrorPoint = 343;
		Pixel leftPixel = null;
    		Pixel rightPixel = null;
    		int count = 0;
    		Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    		for (int row = 236; row < 322; row++)
   		 {
      // loop from 13 to just before the mirror point
      			for (int col = 236; col < mirrorPoint; col++)
      			{

        		leftPixel = pixels[row][col];
        		rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        		rightPixel.setColor(leftPixel.getColor());
  			    }
   		}		
	  }	

	public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical)
	{
		if (vertical)
		{
			int mirrorPoint = x2;
			Pixel leftPixel = null;
			Pixel rightPixel = null;
			Pixel [][]pixels = this.getPixels2D();
			for (int row = y1; row<y2;row++)
			{
				for (int col = x1; col<mirrorPoint; col++)
				{
					leftPixel = pixels[row][col];
		                        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                		        rightPixel.setColor(leftPixel.getColor());
                            	}
                	}
          	}
		else
		{
			int mirrorPoint = y2; 
			Pixel topPixel = null;
			Pixel bottomPixel = null;
			Pixel [][] pixels = this.getPixels2D();
			for (int row = y1; row <mirrorPoint; row++)
			{
				for (int col = x1; col<x2; col++)
				{
					topPixel = pixels[row][col];
					bottomPixel = pixels[mirrorPoint-row+mirrorPoint][col];
					bottomPixel.setColor(topPixel.getColor());
				}
			}
		}
	}

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the:
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }


	public void copy2 (Picture fromPic, int fromStartRow, int fromStartCol, int fromEndRow, int fromEndCol, int toStartRow, int toStartCol, int toEndRow, int toEndCol)
	{
		Pixel fromPixel = null;
		    Pixel toPixel = null;
		    Pixel[][] toPixels = this.getPixels2D();
		    Pixel[][] fromPixels = fromPic.getPixels2D();
		    for (int fromRow = fromStartRow, toRow = toStartRow;
			 fromRow < fromEndRow &&
			 toRow < toEndRow;
			 fromRow++, toRow++)
		    {
		      for (int fromCol=  fromStartCol , toCol = toStartCol;
			   fromCol < fromEndCol &&
			   toCol < toEndCol;
			   fromCol++, toCol++)
		      {
			fromPixel = fromPixels[fromRow][fromCol];
			toPixel = toPixels[toRow][toCol];
			toPixel.setColor(fromPixel.getColor());
		      }
		    }
	}


	public void myCollage()
	{
		Picture lens = new Picture("lenssmall.jpg");
		this.copy(lens, 100,100);
		this.copy(lens, 200,200);
		this.copy(lens, 300,300);
		Picture lens1 = new Picture(lens);
		Picture lens2  = new Picture (lens1);
		lens1.negate();
		this.copy(lens1, 0,0);
		lens.mirrorVertical();
		this.copy(lens, 0,200);
		lens2.grayscale();
		this.copy(lens2, 50, 400);
		this.mirrorDiagonal();
		this.write("myCollage.jpg");
	}
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
	}
}
	Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    Color bottomColor = null;
	      for (int col = 0; col < pixels[0].length; col++)
	      {
		for (int row = 0; row < pixels.length-1; row++)
		{
		topPixel = pixels[row][col];
		bottomPixel = pixels[row+1][col];
		bottomColor = bottomPixel.getColor();
		if (topPixel.colorDistance(bottomColor) >
		    edgeDist)
		  topPixel.setColor(Color.BLACK);
		else
		  topPixel.setColor(Color.WHITE);
	      }
	    }
}

	public void blur (int x, int y, int w, int h)
	{
		Pixel p1 = null; 
		Pixel p2 = null; 
		Pixel p3 = null;
		Pixel p4 = null; 
		Pixel p5 = null; 
		Pixel p6 = null; 
		Pixel p7 = null; 
		Pixel p8 = null;
		Pixel current = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = x+1; row< x+h-1;row++)
		{
			for (int col = y+1; col< y+w-1;col++)
			{
				current = pixels[row][col];
				p1 = pixels[row-1][col-1];
				p2 = pixels[row-1][col];
				p3 = pixels[row-1][col+1];
				p4 = pixels[row][col-1];
				p5 = pixels[row][col+1];
				p6 = pixels[row+1][col-1];
				p7 = pixels[row+1][col];
				p8 = pixels[row+1][col+1];
				current.setRed((p1.getRed()+p2.getRed()+p3.getRed()+p4.getRed()+p5.getRed()+p6.getRed()+p7.getRed()+p8.getRed())/8);
				current.setGreen((p1.getGreen()+p2.getGreen()+p3.getGreen()+p4.getGreen()+p5.getGreen()+p6.getGreen()+p7.getGreen()+p8.getGreen())/8);
				current.setBlue((p1.getBlue()+p2.getBlue()+p3.getBlue()+p4.getBlue()+p5.getBlue()+p6.getBlue()+p7.getBlue()+p8.getBlue())/8);
			}
		}

		for (int row = x+1; row < x+h-1;row++)
		{
			current = pixels[row][y];
			p2 = pixels[row-1][y];
                        p3 = pixels[row-1][y+1];
			p5 = pixels[row][y+1];
			p7 = pixels[row+1][y];
                        p8 = pixels[row+1][y+1];
			current.setRed((p2.getRed()+p3.getRed()+p5.getRed()+p7.getRed()+p8.getRed())/5);
			current.setGreen((p2.getGreen()+p3.getGreen()+p5.getGreen()+p7.getGreen()+p8.getGreen())/5);
			current.setBlue((p2.getBlue()+p3.getBlue()+p5.getBlue()+p7.getBlue()+p8.getBlue())/5);

		}

		for (int row = x+1; row < x+h-1;row++)
                {
                        current = pixels[row][y+w];
                        p1 = pixels[row-1][y+w-1];
                        p2 = pixels[row-1][y+w];
			p4 = pixels[row][y+w-1];
			p6 = pixels[row+1][y+w-1];
                        p7 = pixels[row+1][y+w];
			current.setRed((p1.getRed()+p2.getRed()+p4.getRed()+p6.getRed()+p7.getRed())/5);
                        current.setGreen((p1.getGreen()+p2.getGreen()+p4.getGreen()+p6.getGreen()+p7.getGreen())/5);
                        current.setBlue((p1.getBlue()+p2.getBlue()+p4.getBlue()+p6.getBlue()+p7.getBlue())/5);

                }

		for (int col = y+1; col<y+w-1;col++)
		{
			current = pixels[x][col];
			p4 = pixels[x][col-1];
                        p5 = pixels[x][col+1];
                        p6 = pixels[x+1][col-1];
                        p7 = pixels[x+1][col];
                        p8 = pixels[x+1][col+1];
			current.setRed((p4.getRed()+p5.getRed()+p6.getRed()+p7.getRed()+p8.getRed())/5);
			current.setGreen((p4.getGreen()+p5.getGreen()+p6.getGreen()+p7.getGreen()+p8.getGreen())/5);
			current.setBlue((p4.getBlue()+p5.getBlue()+p6.getBlue()+p7.getBlue()+p8.getBlue())/5);
		}

		for (int col = y+1; col<y+w-1;col++)
		{
			current = pixels[x+h][col];
			 p1 = pixels[x+h-1][col-1];
                         p2 = pixels[x+h-1][col];
                         p3 = pixels[x+h-1][col+1];
                         p4 = pixels[x+h][col-1];
                         p5 = pixels[x+h][col+1];

			current.setRed((p1.getRed()+p2.getRed()+p3.getRed()+p4.getRed()+p5.getRed())/5);
			current.setGreen((p1.getGreen()+p2.getGreen()+p3.getGreen()+p4.getGreen()+p5.getGreen())/5);
			current.setBlue((p1.getBlue()+p2.getBlue()+p3.getBlue()+p4.getBlue()+p5.getBlue())/5);
		}
	
		pixels[x][y].setRed((pixels[x+1][y].getRed()+pixels[x][y+1].getRed()+pixels[x+1][y+1].getRed())/3);
		pixels[x][y+w].setRed((pixels[x][y+w-1].getRed()+pixels[x+1][y+w-1].getRed()+pixels[x+1][y+w].getRed())/3);
		pixels[x+h][y].setRed((pixels[x+h-1][y].getRed()+pixels[x+h-1][y+1].getRed()+pixels[x+h][y+1].getRed())/3);
		pixels[x+h][y+w].setRed((pixels[x+h-1][y+w].getRed()+pixels[x+h-1][y+w-1].getRed()+pixels[x+h][y+w-1].getRed())/3);


		pixels[x][y].setBlue((pixels[x+1][y].getBlue()+pixels[x][y+1].getBlue()+pixels[x+1][y+1].getBlue())/3);
                pixels[x][y+w].setBlue((pixels[x][y+w-1].getBlue()+pixels[x+1][y+w-1].getBlue()+pixels[x+1][y+w].getBlue())/3);
                pixels[x+h][y].setBlue((pixels[x+h-1][y].getBlue()+pixels[x+h-1][y+1].getBlue()+pixels[x+h][y+1].getBlue())/3);
                pixels[x+h][y+w].setBlue((pixels[x+h-1][y+w].getBlue()+pixels[x+h-1][y+w-1].getBlue()+pixels[x+h][y+w-1].getBlue())/3);

		pixels[x][y].setGreen((pixels[x+1][y].getGreen()+pixels[x][y+1].getGreen()+pixels[x+1][y+1].getGreen())/3);
                pixels[x][y+w].setGreen((pixels[x][y+w-1].getGreen()+pixels[x+1][y+w-1].getGreen()+pixels[x+1][y+w].getGreen())/3);
                pixels[x+h][y].setGreen((pixels[x+h-1][y].getGreen()+pixels[x+h-1][y+1].getGreen()+pixels[x+h][y+1].getGreen())/3);
                pixels[x+h][y+w].setGreen((pixels[x+h-1][y+w].getGreen()+pixels[x+h-1][y+w-1].getGreen()+pixels[x+h][y+w-1].getGreen())/3);
	}


	public void edgeDetection2()
  
	{
		Pixel [][]pixels = this.getPixels2D();
		for (int row = 0; row<pixels.length;row++)
		{
			for (int col = 0; col<pixels[0].length;col++)
			{
				if (pixels[row][col].getRed()>=50&&pixels[row][col].getGreen()>50&&pixels[row][col].getBlue()>50)
				{
					
                  			pixels[row][col].setColor(Color.WHITE);
                		}
				else
                  			pixels[row][col].setColor(Color.BLACK);
              		}
            	}
}	


	    
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
