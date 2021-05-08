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
			System.out.println("Kay�t alan�nda bo� alan b�rakmay�n�z.");
		}
		
		else if(user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakterden olu�mal�d�r!");
		}
		else if(!isEmail) {
			System.out.println("E-posta alan� e-posta format�nda olmal�d�r.(example@example.com)");
		}
		else if(user.getFirstName().length()<2 || user.getLastName().length()<2 ) {
			System.out.println("Ad ve soyad en az iki karakterden olu�mal�d�r.");
		}
		else if(repeatMail){
					System.out.println("Bu mail daha �nce kullan�ld�!");
		}
		System.out.println("L�tfen mail adresinize gelen do�rulama linkine t�klay�n�z.");
		checkMailService.checkMail("Email onaylama i�lemi ba�ar�l�.");
		userDao.add(user);
	}

	@Override
	public void login(User user) {
		if(user.getEmail()==null||user.getPassword()==null) {
			System.out.println("L�tfen gerekli alanlar� doldurunuz.");
		}
		else {
			System.out.println("Kullan�c� giri�i ba�ar�l�.");
		}
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� hesap silme i�lemi ba�ar�l�.");
	}

	@Override
	public void registerWithGoogle(User user) {
		userDao.addwithGoogle(user);
	}

}
