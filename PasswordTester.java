
//This class will test the strength and content of a given password

	public class PasswordTester {

		private String password;
		private char ch;
		private String user;
		public static final int PSSWD_LEN = 10;
		public static final int ADMIN_PSSWD_LEN = 13;
		
		//constructs a new class object
		public PasswordTester(String password, String user) {
			this.password = password;
			this.user = user;
		}
		
		//checks if the password length is adequate
		public boolean isLongEnough() {
			if(user.contains("admin")) {
				if(password.length() < ADMIN_PSSWD_LEN) {
					return false;
				}
			} else if(password.length() < PSSWD_LEN) {
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
		
		//checks if the user is an admin
		public boolean isAdmin() {
			if(user.equalsIgnoreCase("Admin")) {
				return true;
			}
			return false;
		}
		
		//checks if the password contains at least 3 special characters for admin user
		public boolean hasSpecialChar() {
			String specialChars = "!@#$%^&*";
			int charNum = 0;
			long count = 0;
			if(isAdmin()==true) {
				for(int i = 0; i < specialChars.length(); i++) {
					ch = specialChars.charAt(i);
					if(password.contains(String.valueOf(ch))) {	
						count = password.chars().filter(s -> s == ch).count();
						charNum = (int) (charNum + count);
						if(charNum == 3) {
							return true;
						}
						
					} 
							
				}
			
			} else if(user.contains("normal")) {
				for(int i = 0; i < specialChars.length(); i++) {
					ch = specialChars.charAt(i);
					if(password.contains(String.valueOf(ch)) || !password.contains(String.valueOf(ch))) {
						return true;
					}
				}
			}
			return false;
		}

	}
