//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		int count=0;
		for (int i=0; i<sentence.length();i++)
		{
			if (sentence.charAt(i)==' ')
			{
				count++;
			}
		}
		wordRay=new String[count+1];

		int count2=0;
		int p=0;
		for (int i=0; i<sentence.length();i++)
		{
			
			if (sentence.charAt(i)==' ')
			{
				wordRay[count2]=sentence.substring(p, i);
				p=i+1;
				count2=count2+1;
			}
		
		}
		wordRay[count2]=sentence.substring(p);
	//	System.out.println(Arrays.toString(wordRay));
	}

	public void sort()
	{
		Arrays.sort(wordRay);
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i<wordRay.length;i++)
		{
			output= output+ "\n"+wordRay[i];
		}
		
		return output+"\n\n";
	}
}
