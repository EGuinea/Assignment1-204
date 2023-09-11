
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	String password, password2;
	@Before
	public void setUp() throws Exception {
		password = "Tester123!";
		password2 = "Test";
	}

	@After
	public void tearDown() throws Exception {
		password = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Tester1!"));
			assertEquals(true,PasswordCheckerUtility.isValidPassword("test"));
		}
		catch(LengthException e)
		{
			System.out.println(e.getMessage());
			assertEquals("The password must be at least 6 characters long", e.getMessage());
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides lengthException", true);
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() throws NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException
	{
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Tester123"));
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("tester123"));
		}
		catch(NoUpperAlphaException e)
		{
			System.out.println(e.getMessage());
			assertEquals("no uppercase alphabetic",e.getMessage());
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides NoUpperAlphaException", true);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Tester123!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("TESTER123!"));
		}
		catch(NoLowerAlphaException e)
		{
			System.out.println(e.getMessage());
			assertEquals("no lowercase alphabetic.",e.getMessage());
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides NoLowerAlphaException", true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Teeter123!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Teeter123!"));
		}
		catch(InvalidSequenceException e)
		{
			System.out.println(e.getMessage());
			assertEquals("more than 2 of same character.", e.getMessage());
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides InvalidSequenceException", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Teeter123!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Teeter123!"));
		}
		catch(InvalidSequenceException e)
		{
			System.out.println(e.getMessage());
			assertEquals("more than 2 of same character.", e.getMessage());
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides InvalidSequenceException", true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Tester1!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Tester!"));
		}
		catch(NoDigitException e)
		{
			System.out.println(e.getMessage());
			assertEquals(" No Numbers", e.getMessage());
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some other exception besides NoDigitException", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Abrakadabra123!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("HeloImBob123!"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertFalse("Threw some exception", true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Testeer1!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("abrakadabra123!"));
			assertTrue(PasswordCheckerUtility.isValidPassword("HelloImBob123!"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some exceptions", true);
		}
	}
	
}
