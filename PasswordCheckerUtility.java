import java.util.ArrayList;
public class PasswordCheckerUtility {
	
	///Edwin Guinea 9/10 CMSC 204 
	public static boolean isValidPassword(String passwordString) throws NoDigitException, NoUpperAlphaException, NoLowerAlphaException, NoSpecialCharacterException, InvalidSequenceException, LengthException{
		
		boolean hasDigit = false;
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasSpecial = false;
		boolean hasSequence = false;
		if(passwordString.length()< 6) {throw new LengthException();}
		for(int i = 0; i < passwordString.length();i++) {
			if (Character.isDigit(passwordString.charAt(i))) hasDigit = true;
		}
		if(!hasDigit)throw new NoDigitException();
		for(int i = 0; i < passwordString.length();i++) {
			if (Character.isUpperCase(passwordString.charAt(i))) hasUpper = true;	
		}
		if(!hasUpper)throw new NoUpperAlphaException();
		for(int i = 0; i < passwordString.length();i++) {
			if (Character.isLowerCase(passwordString.charAt(i))) hasLower = true;		
		}
		if(!hasLower)throw new NoLowerAlphaException();
		for(int i = 0; i < passwordString.length();i++) {
			if (!(Character.isLetterOrDigit(passwordString.charAt(i)))) hasSpecial = true;	
		}
		if(!hasSpecial)throw new NoSpecialCharacterException();
		for(int i = 0; i < passwordString.length() - 1;i++) {
			if (passwordString.charAt(i) == passwordString.charAt(i + 1)) hasSequence = true;
		}
		if(hasSequence)throw new InvalidSequenceException();
		return true;/*The exceptions are every other possibility*/
	}
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException{
		if(passwordString.length()<10) throw new WeakPasswordException();
		return false;
	}
	public static boolean comparePasswordsWithReturn(String passwordString, String passwordAString) {
		if(passwordString.equals(passwordAString)) {
			return true;
		}
		return false;
	}
	public static boolean comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
		return true;
		
	}
	public static boolean isValidLength(String password) throws LengthException {
		if(password.length()< 6) throw new LengthException();
		return true;
		
	}
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String password : passwords) {
            try {
		           if (PasswordCheckerUtility.isValidPassword(password));
		           
            	}
		    catch(NoDigitException e) {
		            	invalidPasswords.add(password + " No digit");
		            } 
            catch (NoUpperAlphaException e) {
		            	invalidPasswords.add(password + " No UpperCase");
					} 
            catch (NoLowerAlphaException e) {
						invalidPasswords.add(password + " The password must contain at least one lowercase alphabetic character");
					} 
            catch (NoSpecialCharacterException e) {
						invalidPasswords.add(password + " The password must contain at least one special character");
					} 
            catch (InvalidSequenceException e) {
						invalidPasswords.add(password + " Too many Characters in sequence");
					} 
            catch (LengthException e) {
						invalidPasswords.add(password + " Not long enough");
				}
	            
	    }

	    return invalidPasswords;
		
	}
	public static boolean hasUpperAlpha(String string) throws NoUpperAlphaException {
		for(int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(string.charAt(i))) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	
}
