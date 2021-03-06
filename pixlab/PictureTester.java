/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

	public static void testKeepOnlyBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();	
		beach.keepOnlyBlue();
		beach.explore();
	} 
	
	public static void testNegate()
	{
		Picture beach = new Picture ("beach.jpg");
		beach.explore();
		beach.negate();
		beach.explore();
	}

	public static void testGrayscale()
	{
		Picture beach = new Picture ("beach.jpg");
	//	beach.explore();
		beach.grayscaleAverage();
		beach.explore();
		Picture beach2= new Picture("beach.jpg");
		beach2.grayscaleLightness();
		beach2.explore();
		Picture beach3 = new Picture("beach.jpg");
		beach3.grayscaleLuminosity();
		beach3.explore();
	}
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
	public static void testMirrorVerticalRightToLeft()
	{
		Picture caterpillar = new Picture ("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVerticalRightToLeft();
		caterpillar.explore();
	}


	public static void testMirrorHorizontal()
	{
		Picture caterpillar = new Picture ("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontal();
		caterpillar.explore();
	}
	
	public static void testMirrorHorizontalBotToTop()
	{
		Picture caterpillar = new Picture ("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorHorizontalBotToTop();
		caterpillar.explore();
	}

	public static void testMirrorDiagonal()
	{
		Picture caterpillar = new Picture ("beach.jpg");
		caterpillar.mirrorDiagonal();
		caterpillar.explore();
	}  
/** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }


	public static void testEdgeDetection2()
 	 {
   	 Picture swan = new Picture("swan.jpg");
   	 swan.edgeDetection2();
    	 swan.explore();
	  }
	public static void testFixUnderwater()
	{
		Picture water = new Picture("water.jpg");
		water.fixUnderwater();
		water.explore();
			
	}


	public static void testMirrorArms()
	{
		Picture snowman = new Picture ("snowman.jpg");
		snowman.mirrorArms();
		snowman.explore();
	}

	public static void testMirrorGull()
	{
		Picture gull = new Picture ("seagull.jpg");
		gull.mirrorGull();
		
		gull.explore();
	}

	public static void testMirrorRectangle()
	{
		Picture gull = new Picture ("seagull.jpg");
		gull.mirrorRectangle(236,236,343,322, true);
		gull.explore();
	}

	public static void testCopy()
	{
		Picture gull = new Picture ("seagull.jpg");
		gull.copy2(gull, 10, 10, 100,100, 200, 200, 290,290);
		gull.explore();
	}


	public static void testMyCollage()
	{
		Picture beach = new Picture("beach.jpg");
		beach.myCollage();
		beach.explore();
	}


	public static void testBlur(int x, int y, int w, int h, int n)
	{
		Picture redMoto = new Picture("redMotorcycle.jpg");
		for (int i = 0; i<n;i++)
		{
			redMoto.blur(x, y, w, h);
		}
		redMoto.explore();
	}

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//	testBlur(180,160,25,25,1);
//	testBlur(180,160,25,25,5);
	testBlur(180,160,25,25,10);


//	testBlur(0,0,639,479,10);
//    testZeroBlue();
  //  testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
   // testNegate();
//    testGrayscale();
//    testFixUnderwater();
    //testMirrorVertical();
//	testMirrorVerticalRightToLeft();
// 	testMirrorHorizontal();
//	testMirrorHorizontalBotToTop();
	
//	  testMirrorTemple();
  //  testMirrorArms();
  //  testMirrorGull();
//	testMirrorRectangle();
//    testMirrorDiagonal();
    //testCollage();
  //  testCopy();
//	testMyCollage();
   // testEdgeDetection();
   // testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
