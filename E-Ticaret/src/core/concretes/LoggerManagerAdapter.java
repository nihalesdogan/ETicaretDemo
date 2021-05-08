package core.concretes;

import core.abstracts.LoggerService;
import loginGoogle.LoginManager;

public class LoggerManagerAdapter implements LoggerService {

	@Override
	public void loginWithGoogle(String message) {
		LoginManager manager=new LoginManager();
		manager.login(message);
	}

}
