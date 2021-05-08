package loginGoogle;

import core.abstracts.LoggerService;

public class LoginManager implements LoggerService  {
	@Override
	public void loginWithGoogle(String message) {
		System.out.println("Google hesabý ile üyelik tamamlandý.");
	}

	public void login(String message) {
		// TODO Auto-generated method stub
		
	}

}
