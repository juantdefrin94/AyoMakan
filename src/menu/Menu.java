package menu;

import models.User;
import repository.UserRepository;
import utils.Scan;

public class Menu {

	private Scan sc = Scan.getInstance();
	
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
		
		UserRepository userRepo = UserRepository.getInstance();
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
		
	}

}
