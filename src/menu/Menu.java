package menu;

import iterator.ShowFood;
import models.Food;
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
		int pil = 0;
		do {
			System.out.print(
					"Ay0 m@k4n!!\n" +
							"===========\n" +
							"1. Order Food\n" +
							"2. Balance Check\n" +
							"3. Top Up\n" +
							"4. Back\n" +
							">> "
					);
			pil = sc.getNum();
			
			switch (pil) {
			case 1: 
				orderFood();
				break;
			
			default:
				break;
			}		
		} while (pil != 4);
	}
	
	public void orderFood() {
		ShowFood showFood = new ShowFood();
		
		if(showFood.foodSize() == 0) {
			sc.showAlert("Data not Found!");
			return;
		}
		
		System.out.println("Menu :");
		int no = 1;
		while(showFood.hasNext()) {
			Food currFood = showFood.getNext();
			System.out.println(no++ + ". " + currFood.getFoodName() + " - Rp. " + currFood.getFoodPrice());
		}
		System.out.println("0. Back");
		no--;
		
		int menu = 0;
		while(true) {
			System.out.print("Please Choose The Menu : ");
			menu = sc.getNum();
			if(menu == 0) return;
			if(menu < 0 || menu > no) sc.showAlert("Please input between [0 - " + no + "]!");
			else break;
		}
		
		
	}
	
	public void adminMainMenu() {
		int pil = 0;
		do {
			System.out.print(
					"===== Admin Menu =====\n" +
					"Ay0 m@k4n!!\n" +
							"===========\n" +
							"1. Order Food\n" +
							"2. Balance Check\n" +
							"3. Top Up\n" +
							"4. Add Food\n" +
							"4. Back\n" +
							">> "
					);
			pil = sc.getNum();
			
			switch (pil) {
			case 1: 
				System.out.println("ini pil 1");
				break;
			
			default:
				break;
			}		
		} while (pil != 5);
	}
	
	public void createCardMenu() {
		int pil = 0;
		do {
			System.out.print(
					"Ay0 m@k4n!!\n" +
							"===========\n" +
							"1. Create AyoPay" +
							"2. Create SophiPay\n" +
							"3. Back\n" +
							">> "
					);
			pil = sc.getNum();
			
			switch (pil) {
			case 1: 
				System.out.println("ini pil 1");
				break;
			
			default:
				break;
			}		
		} while (pil != 3);
	}
	
	public void topUpMenu() {
		
	}
}
