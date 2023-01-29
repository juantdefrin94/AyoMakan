package menu;

import java.util.ArrayList;

import iterator.FoodCollection;
import iterator.ICollection;
import iterator.Iterator;
import models.Food;
import models.User;
import repository.FoodRepository;
import repository.UserRepository;
import utils.Scan;

public class Menu {

	private Scan sc = Scan.getInstance();
	private UserRepository userRepo = UserRepository.getInstance();
	private FoodRepository foodRepo = FoodRepository.getInstance();
	private User currUser;
	
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
		int i = 0;
		
		for (User currUser : userRepo.getUserList()) {
			
			if(currUser.getUsername().equals(username)) {
				
				isExist = true;
				
				System.out.print("Password : ");
				password = sc.getText();
				
				if(currUser.getPassword().equals(password)) {
					
					this.currUser = userRepo.getUserList().get(i);
					
					//if admin
					if(currUser.getUsername().equals("admin")) return 1;
					else return 2;
				}
				sc.showAlert("Wrong Password!\n"); 
				
				break;
			}
			
			i++;
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
							"0. Back\n" +
							">> "
					);
			pil = sc.getNum();
			
			switch (pil) {
			case 1: 
				orderFood();
				break;
			case 2:
				checkBalance();
			default:
				break;
			}		
		} while (pil != 4);
	}
	
	private void checkBalance() {
		System.out.print("Your Balance : " + currUser.getBalance()); 
		sc.showAlert("");
	}

	private void orderFood() {
		System.out.println("Menu :");
		int size = iterateFood(foodRepo.getFoodList());
		if(size == 0) {
			sc.showAlert("Data not Found!");
			return;
		}
		
		System.out.println("0. Back");
		
		int menu = 0;
		while(true) {
			System.out.print("Please Choose The Menu : ");
			menu = sc.getNum();
			if(menu == 0) return;
			if(menu < 0 || menu > size) sc.showAlert("Please input between [0 - " + size + "]!");
			else break;
		}
	}
	
	private int iterateFood(ArrayList <Food>foodList) {
		int size = 0;
		ICollection collection = new FoodCollection(foodList);
		Iterator iterator = collection.createIterator();
		while(iterator.hasNext()) {
			Food curr = (Food) iterator.getNext();	
			System.out.println(++size + ". " + curr.getFoodName() + " - Rp. " + curr.getFoodPrice());
		}
		return size;
	}
	
	public void adminMainMenu() {
		int pil = 0;
		do {
			System.out.print(
					"===== Admin Menu =====\n" +
					"Ay0 m@k4n!!\n" +
							"===========\n" +
							"1. Edit Food\n" +
							"2. Add Food\n" +
							"0. Back\n" +
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
							"0. Back\n" +
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
