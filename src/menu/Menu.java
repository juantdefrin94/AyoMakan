package menu;

import models.User;
import repository.UserRepository;
import utils.Scan;

public class Menu {

	private Scan sc = Scan.getInstance();
	private UserRepository userRepo = UserRepository.getInstance();
	
	public Menu() {}
	
	public int showDefaultMenu() {
		int pil = 0;
		System.out.print(
				"Ay0 m@k4n!!\n" +
				"===========\n" +
				"1. Login\n" +
				"2. Register\n" +
				"0. Exit\n" +
				">> "
			);
		pil = sc.getNum();
		return pil;
	}

	public boolean loginMenu() {
		
		String username = "", password = "";
		boolean isExist = false;
		
		System.out.print("Username : ");
		username = sc.getText();
		
		for (User currUser : userRepo.getUserList()) {
			
			if(currUser.getUsername().equals(username)) {
				
				isExist = true;
				
				System.out.println("Password : ");
				password = sc.getText();
				
				if(currUser.getPassword().equals(password)) {
					return true;
				}
				System.out.println("Wrong Password!\n"); sc.getEnter();
				
				break;
			}
		}
		
		if(!isExist) {
			System.out.println("Username not Found!");
		}else {
			System.out.println("Wrong password!");
		}
		
		return false;
	}

	public void registerMenu() {
		String username = "", password = "";
		
		//get username
		while(true) {
			System.out.println("Username : ");
			username = sc.getText();
			int userLen = username.length();
			if(userLen >= 8) break;
			else System.out.println("Username must equal to 8 or more!");
		}
		
		//get password
		while(true) {
			System.out.println("Password : ");
			password = sc.getText();
			int passLen = password.length();			
			if(passLen >= 8) break;
			else System.out.println("Password must equal to 8 or more!");
		}
		
		//add user to repo
		User newUser = new User(username, password);
		userRepo.addUserList(newUser);	
		
	}

}
