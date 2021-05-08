package business.concretes;

import java.util.regex.Pattern;

import business.abstracts.CheckMailService;
import business.abstracts.UserService;
import core.abstracts.LoggerService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import loginGoogle.LoginManager;

public class UserManager implements UserService {
	private UserDao userDao;
	private CheckMailService checkMailService;
	private LoggerService loggerService;

	public UserManager(UserDao userDao, CheckMailService checkMailService, LoggerService loggerService) {
		super();
		this.userDao = userDao;
		this.checkMailService = checkMailService;
		this.loggerService=loggerService;
	}

	@Override
	public void register(User user) {
		String regex="(?simx)\\b[A-Z0-9._%+-]+" + "@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
		boolean isEmail=Pattern.matches(regex, user.getEmail());
		boolean repeatMail=false;
		
		if(user.getFirstName()==null|| user.getLastName()==null || user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kayýt alanýnda boþ alan býrakmayýnýz.");
		}
		
		else if(user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr!");
		}
		else if(!isEmail) {
			System.out.println("E-posta alaný e-posta formatýnda olmalýdýr.(example@example.com)");
		}
		else if(user.getFirstName().length()<2 || user.getLastName().length()<2 ) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr.");
		}
		else if(repeatMail){
					System.out.println("Bu mail daha önce kullanýldý!");
		}
		System.out.println("Lütfen mail adresinize gelen doðrulama linkine týklayýnýz.");
		checkMailService.checkMail("Email onaylama iþlemi baþarýlý.");
		userDao.add(user);
	}

	@Override
	public void login(User user) {
		if(user.getEmail()==null||user.getPassword()==null) {
			System.out.println("Lütfen gerekli alanlarý doldurunuz.");
		}
		else {
			System.out.println("Kullanýcý giriþi baþarýlý.");
		}
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý hesap silme iþlemi baþarýlý.");
	}

	@Override
	public void registerWithGoogle(User user) {
		userDao.addwithGoogle(user);
	}

}
