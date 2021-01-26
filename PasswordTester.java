//This class will test the strength and content of a given password

	public class PasswordTester {

		private String password;
		private char ch;
		public static final int PSSWD_LEN = 8;
		
		//constructs a new class object
		public PasswordTester(String password) {
			this.password = password;
		}
		
		//checks if the password length is adequate
		public boolean isLongEnough() {
			if(password.length() < PSSWD_LEN) {
				return false;
			}
			return true;
		}
		
		//checks if the password contains at least 1 letter
		public boolean hasLetter() {
			for(int i = 0; i < password.length(); i++) {
				ch = password.charAt(i);
				if(Character.isLetter(ch)) {
					return true;
				}
			}
			return false;
		}
		
		//checks if the password contains at least 1 number
		public boolean hasNumber() {
			for(int i = 0; i < password.length(); i++) {
				ch = password.charAt(i);
				if(Character.isDigit(ch)) {
					return true;
				}
			}
			return false;
		}

	}
