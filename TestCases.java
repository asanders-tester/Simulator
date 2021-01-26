import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestCases {

	private PasswordTester tester;
	
	@Test
	public void lengthOfPassword() {
		tester = new PasswordTester("password123");
		assertTrue(tester.isLongEnough());
	}
	
	@Test
	public void containsLetter() {
		tester = new PasswordTester("12345");
		assertTrue(tester.hasLetter());
	}
	
	@Test
	public void containsNumber() {
		tester = new PasswordTester("password123");
		assertTrue(tester.hasNumber());
	}
	
	@Test
	public void errorMessage() {
		tester = new PasswordTester("12345");
		if(tester.isLongEnough() && tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password does not contain a number");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else if (tester.isLongEnough() && !tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password does not contain a letter");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else if (!tester.isLongEnough() && tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password is not long enough");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else if (!tester.isLongEnough() && !tester.hasLetter() && tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a letter");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else if (!tester.isLongEnough() && tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a number");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());		
		} else if (tester.isLongEnough() && !tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password does not contain a letter and number");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else if (!tester.isLongEnough() && !tester.hasLetter() && !tester.hasNumber()) {
			System.out.println("Error: Password is not long enough and does not contain a letter"
					+ "and number");
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		} else {
			assertTrue(tester.isLongEnough() && tester.hasLetter() && tester.hasNumber());
		}
	}

}
