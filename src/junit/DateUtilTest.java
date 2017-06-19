package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cranfieldlogic.mydate.DateUtil;

public class DateUtilTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testBasicDate()
	{
		try
		{
			DateUtil dt01 = new DateUtil("01/01/2017");
			assertEquals("01/01/2017", dt01.getDateStr());
		}
		catch (Exception e)
		{
			fail("Failed with valid date - 01/01/2017");
		}
	}

	@Test
	public void testNonLeapDate()
	{
		try
		{
			DateUtil dt01 = new DateUtil("29/02/2017");
			assertNotEquals("29/02/2017", dt01.getDateStr());
		}
		catch (Exception e)
		{
			// Valid
		}
	}	

	@Test
	public void testLeapDate()
	{
		try
		{
			DateUtil dt01 = new DateUtil("29/02/2016");
			assertEquals("29/02/2016", dt01.getDateStr());
		}
		catch (Exception e)
		{
			fail("Failed with valid date - 29/02/2016");
		}
	}
	
	@Test
	public void testNonValidChars01()
	{
		try
		{
			DateUtil dt01 = new DateUtil("17/T2/2017");
			assertNotEquals("17/02/2017", dt01.getDateStr());
		}
		catch (Exception e)
		{
			// Valid
		}
	}		

	@Test
	public void testNonValidChars02()
	{
		try
		{
			DateUtil dt01 = new DateUtil("17/-2/2017");
			assertNotEquals("17/02/2017", dt01.getDateStr());
		}
		catch (Exception e)
		{
			// Valid
		}
	}	
	
	@Test
	public void testAddDays01()
	{
		try
		{
			DateUtil dt01 = new DateUtil("17/02/2017");
			assertEquals("17/02/2017", dt01.getDateStr());
			
			dt01.addDays(2);
			assertEquals("19/02/2017", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}	
	
	@Test
	public void testAddDays02()
	{
		try
		{
			DateUtil dt01 = new DateUtil("27/02/2017");
			assertEquals("27/02/2017", dt01.getDateStr());
			
			dt01.addDays(2);
			assertEquals("01/03/2017", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}	

	@Test
	public void testAddDays03()
	{
		try
		{
			DateUtil dt01 = new DateUtil("27/02/2017");
			assertEquals("27/02/2017", dt01.getDateStr());
			
			dt01.addDays(33);
			assertEquals("01/04/2017", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}		
	
	@Test
	public void testAddDays04()
	{
		try
		{
			DateUtil dt01 = new DateUtil("27/02/2017");
			assertEquals("27/02/2017", dt01.getDateStr());
			
			dt01.addDays(365);
			assertEquals("27/02/2018", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}	
	
	@Test
	public void testAddDays05()
	{
		try
		{
			DateUtil dt01 = new DateUtil("27/02/2017");
			assertEquals("27/02/2017", dt01.getDateStr());
			
			dt01.addDays(763);
			assertEquals("01/04/2019", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}
	
	@Test
	public void testAddDays06()
	{
		try
		{
			// Leap year
			DateUtil dt01 = new DateUtil("27/02/2015");
			assertEquals("27/02/2015", dt01.getDateStr());
			
			dt01.addDays(763);
			assertEquals("31/03/2017", dt01.getDateStr());
			
		}
		catch (Exception e)
		{
			fail("Failed data add, throw exception");
		}
	}	
}
