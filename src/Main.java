import java.util.List;

import beans.User;
import controller.UserDao;

public class Main {

	public static void main(String[] args) {
		System.out.println("Preparing to show objects...");
		UserDao ud = new UserDao();
		//ud.insertNewUser();
		List<User> users = ud.getAllUsers();
		for(User u : users){
				
			System.out.println("The DAO found " + u.getUsername() + " id=" + u.getId());
		}
		
		System.out.println("Done");
	}

}
