import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestCases {

	private PasswordTester tester;
	
	@Test
	public void integratedTest() {
		tester = new PasswordTester("password123@@%", "admin");
		assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber() && 
				tester.hasSpecialChar());
	}
	
	@Test
	public void lengthOfPassword() {
		tester = new PasswordTester("password123", "admin");
		assertTrue(tester.isLongEnough());
	}
	
	@Test
	public void lengthOfPassword2() {
		tester = new PasswordTester("password1234!", "admin");
		assertTrue(tester.isLongEnough());
	}
	
	@Test
	public void containsLetter() {
		tester = new PasswordTester("12345", "normal");
		assertTrue(tester.hasLetter());
	}
	
	@Test
	public void containsNumber() {
		tester = new PasswordTester("password12345", "admin");
		assertTrue(tester.hasNumber());
	}
	
	@Test
	public void containsSpecialChars() {
		tester = new PasswordTester("password1234!$%", "admin");
		assertTrue(tester.hasSpecialChar());
	}
	
	//@Test
	public void errorMessage() {
		tester = new PasswordTester("password123", "admin");
		if(tester.isLongEnough() && tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password does not contain a number");	
		
		} else if (tester.isLongEnough() && !tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password does not contain a letter");
		
		} else if (!tester.isLongEnough() && tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password is not long enough");
		
		} else if (!tester.isLongEnough() && !tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a letter");
		
		} else if (!tester.isLongEnough() && tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a number");
		
		} else if (tester.isLongEnough() && !tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password does not contain a letter and number");
		
		} else if (!tester.isLongEnough() && !tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a letter"
					+ "and number");
		} 
		
		if (tester.isAdmin() && !tester.hasSpecialChar()) {
			System.out.println("Error: Password requires 3 special characters");
		}
		assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber() && 
				tester.hasSpecialChar());
	}
	
	

}
