//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
	  for (int i=0; i<ray.size();i++)
	  {
		  if (ray.get(i)%2==1)
		  {
			  for (int j=ray.size()-1;j>i+1;j--)
			  {
				if (ray.get(j)%2==0)
				{

				  return j-i;
				}
			  }
			  return -1;
		  }
	  }
	  return -1;
  }
}
