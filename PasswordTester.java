
	public class PasswordTester {

		private String password;
		private char ch;
		public static final int PSSWD_LEN = 8;
		
		public PasswordTester(String password) {
			this.password = password;
		}
		
		public boolean isLongEnough() {
			if(password.length() < PSSWD_LEN) {
				return false;
			}
			return true;
		}
		
		public boolean hasLetter() {
			for(int i = 0; i < password.length(); i++) {
				ch = password.charAt(i);
				if(Character.isLetter(ch)) {
					return true;
				}
			}
			return false;
		}
		
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
