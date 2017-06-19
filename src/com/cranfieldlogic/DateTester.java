package com.cranfieldlogic;

import com.cranfieldlogic.mydate.DateUtil;

public class DateTester
{

	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			displayUsage();
		}
		else
		{
			try
			{
				DateUtil dateToTest = new DateUtil(args[0]);
				dateToTest.addDays(Integer.parseInt(args[1]));
				
				System.out.println("New Date: " + dateToTest.getDateStr());
			}
			catch (Exception e)
			{
				displayUsage();
			}
		}

	}

	public static void displayUsage()
	{
		System.out.println("Usage: DateTester <date> <days>");
		System.out.println("Where;");
		System.out.println("        <date> is a valid date in the format dd/mm/yyyy");
		System.out.println("        <days> is a valid number of days to add to the date");
	}
}
