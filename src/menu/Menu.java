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
		User newUser = new User(username, password);
		System.out.println("Username : ");
		username = sc.getText();
		Integer userLen = username.length();
		if(userLen >= 8) {
			System.out.println("Password : ");
			password = sc.getText();
			Integer passLen = password.length();
			if(passLen >= 8) {
				userRepo.addUserList(newUser);
			}
			else {
				System.out.println("Password must equal to 8 or more!");
			}	
		}else {	
			System.out.println("Username must equal to 8 or more!");
		}
	}

}
