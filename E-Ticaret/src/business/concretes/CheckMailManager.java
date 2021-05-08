package business.concretes;


import business.abstracts.CheckMailService;

public class CheckMailManager implements CheckMailService {
	@Override
	public void checkMail(String message) {
		System.out.println(message);
		
	}

}
