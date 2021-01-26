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

}
