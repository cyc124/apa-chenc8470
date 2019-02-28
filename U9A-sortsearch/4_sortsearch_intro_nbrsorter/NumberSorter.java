//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count=0;
		while (number>0)
		{
			number=number/10;
			count++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int digit=0;
		int count=0;
		while (number>0)
		{
			digit=number%10;
			sorted[count]=digit;
			number=number/10;
			count++;
		}
		Arrays.sort(sorted);

		return sorted;
	}
}
