package com.cranfieldlogic.mydate;

/**
 * Date utility class to create a data and add a number of days to that date as
 * required.
 * 
 * @author Julian Cranfield
 * @version 1.0
 *
 */
public class DateUtil
{
	private final int[] DAYS_IN_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int day = 0;
	private int month = 0;
	private int year = 0;

	/**
	 * Create a date from a string with the format dd/mm/yyyy
	 * 
	 * @param dateStr
	 * @throws Exception
	 */
	public DateUtil(String dateStr) throws Exception
	{

		// Split the string in to day, month, year and check all three exist.
		String[] dateElements = dateStr.split("/");
		if (dateElements.length == 3)
		{
			setDay(dateElements[0]);
			setMonth(dateElements[1]);
			setYear(dateElements[2]);
		}

		// Validate the date
		if (!isValidDate())
		{
			throw new Exception("The data entered is not a valid date.");
		}
	}

	/**
	 * Get the string representation of the date.
	 * 
	 * @return
	 */
	public String getDateStr()
	{
		return String.format("%1$2d/%2$2d/%3$4d", day, month, year).replace(' ', '0');
	}

	/**
	 * Add a number of adds to the date
	 * 
	 * @param daysToAdd
	 */
	public void addDays(int daysToAdd)
	{
		// Loop while we have days to add moving the months on as required.
		while (daysToAdd > 0)
		{
			// Check if the number of days pushes into next month
			if ((day + daysToAdd) > getDaysInMonth(month, year))
			{
				daysToAdd -= (getDaysInMonth(month, year) - day);
				day = 0;
				if (++month > 12)
				{
					month = 1;
					year++;
				}
			}
			else
			{
				day += daysToAdd;
				daysToAdd = 0;
			}
		}
	}

	/**
	 * Check if the year is a leap year
	 * 
	 * @param year
	 * @return
	 */
	private boolean isLeapYear(int year)
	{
		boolean isLeapYear;

		// Check for leap year is divisible by 4 and not 100 unless divisible by
		// 400.
		isLeapYear = (year % 4 == 0);
		isLeapYear = isLeapYear && (year % 100 != 0);
		isLeapYear = isLeapYear || (year % 400 == 0);

		return isLeapYear;
	}

	/**
	 * Check that the date that has been entered is a valid date with the year
	 * between 0 and 5000
	 * 
	 * @return
	 */
	private boolean isValidDate()
	{
		boolean isValid = false;

		// Check the year
		if (year > 0 && year <= 5000)
		{
			// Check the month
			if (month > 0 && month <= 12)
			{
				// Check the day based on the month, checking for a leap year
				if (day > 0 && day <= getDaysInMonth(month, year))
				{
					isValid = true;
				}
			}
		}

		// Return the result
		return isValid;
	}

	/**
	 * Return the days in the month taking into account the leap years
	 * 
	 * @param mnth
	 * @param yr
	 */
	private int getDaysInMonth(int mnth, int yr)
	{
		return (mnth == 2 && isLeapYear(yr) ? 29 : DAYS_IN_MONTH[mnth]);
	}

	/**
	 * Set the day from the passed in string.
	 * 
	 * @param dayStr
	 * @throws NumberFormatException
	 */
	private void setDay(String dayStr) throws NumberFormatException
	{
		this.day = Integer.parseInt(dayStr);
	}

	/**
	 * Set the month from the passed in string.
	 * 
	 * @param monthStr
	 * @throws NumberFormatException
	 */
	private void setMonth(String monthStr) throws NumberFormatException
	{
		this.month = Integer.parseInt(monthStr);
	}

	/**
	 * Set the year from the passed in string.
	 * 
	 * @param yearStr
	 * @throws NumberFormatException
	 */
	private void setYear(String yearStr) throws NumberFormatException
	{
		this.year = Integer.parseInt(yearStr);
		;
	}
}
