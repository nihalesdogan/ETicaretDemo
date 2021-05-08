
import business.abstracts.UserService;
import business.concretes.CheckMailManager;
import business.concretes.UserManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import loginGoogle.LoginManager;

public class Main {

	public static void main(String[] args) {
		User user=new User(1,"Nihal","Esdogan","nihalesdogan@hotmail.com","123456");
		UserService userService=new UserManager(new HibernateUserDao(),new  CheckMailManager(), new LoginManager());
		userService.register(user);
		userService.registerWithGoogle(user);
	}

}
