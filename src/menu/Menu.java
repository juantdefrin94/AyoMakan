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

	public int loginMenu() {
		
		String username = "", password = "";
		boolean isExist = false;
		
		System.out.print("Username : ");
		username = sc.getText();
		
		for (User currUser : userRepo.getUserList()) {
			
			if(currUser.getUsername().equals(username)) {
				
				isExist = true;
				
				System.out.print("Password : ");
				password = sc.getText();
				
				if(currUser.getPassword().equals(password)) {
					
					//if admin
					if(currUser.getUsername().equals("admin")) return 1;
					else return 2;
				}
				sc.showAlert("Wrong Password!\n"); 
				
				break;
			}
		}
		
		if(!isExist) {
			System.out.println("Username not Found!");
		}else {
			System.out.println("Wrong password!");
		}
		
		return 0;
	}

	public void registerMenu() {
		String username = "", password = "";
		boolean isExist = false;
		
		//get username
		while(true) {
			System.out.print("Username ('back' to back): ");
			username = sc.getText();
			if(username.equals("back")) return;
			
			int userLen = username.length();
			if(userLen >= 8) break;
			else sc.showAlert("Username must equal to 8 or more!");
			
			isExist = false;
			for (User curr : userRepo.getUserList()) {
				if(curr.getUsername().equals(username)) isExist = true;
			}
			
			if(isExist) sc.showAlert("Username is already exist!");
			else break;
		}
		
		//get password
		while(true) {
			System.out.print("Password (min 8 characters) ('back' to back) : ");
			password = sc.getText();
			if(password.equals("back")) return;
			
			int passLen = password.length();	
			if(passLen >= 8) break;
			else sc.showAlert("Password must equal to 8 or more!");
		}
		
		//add user to repo
		User newUser = new User(username, password);
		userRepo.addUserList(newUser);
		
		sc.showAlert("Succesfully registering user");
		
	}
	
	public void userMainMenu() {
		
	}
	
	public void adminMainMenu() {
		
	}

}
