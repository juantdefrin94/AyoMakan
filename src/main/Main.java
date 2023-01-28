package main;

import menu.Menu;
import models.Food;
import models.User;
import repository.FoodRepository;
import repository.UserRepository;
import utils.Scan;

public class Main {

	//User Repository dapat digunakan dibanyak class dengan 1 class yang sama (Singleton)
	UserRepository userRepository = UserRepository.getInstance();
	FoodRepository foodRepository = FoodRepository.getInstance();
	Scan sc = Scan.getInstance();
	
	Menu menu = new Menu();
	
	public Main() {
		init();
		int pil = 0;
		int isLoggedIn = 0;
		while(true) {
			clearScreen();
			isLoggedIn = 0;
			pil = menu.showDefaultMenu();
			switch (pil) {
			case 1:
				isLoggedIn = menu.loginMenu();
//				if(isLoggedIn == 1 || isLoggedIn == 2) sc.showAlert("Succesfully logged in!");
				
				if(isLoggedIn == 1) { 
					clearScreen();
					menu.adminMainMenu();
				}
				else if(isLoggedIn == 2) {
					clearScreen();
					menu.userMainMenu();
				}
				break;
			case 2:
				menu.registerMenu();
				break;
			default:
				sc.showAlert("Please Enter 0 - 2!");
				break;
			}
		}
	}
	
	private void init() {
		//adding dummy data
		User newUser = new User("admin", "admin");
		userRepository.addUserList(newUser);
		
		newUser = new User("Christopher", "2440025292");
		userRepository.addUserList(newUser);
		
		newUser = new User("Juan", "2440021230");
		userRepository.addUserList(newUser);
		
		
		//adding dummy food Data
		Food newFood = new Food("Nasi Goreng", 20000);
		foodRepository.addFoodList(newFood);
		
		newFood = new Food("Martabak", 30000);
		foodRepository.addFoodList(newFood);
		
		newFood = new Food("Sate", 15000);
		foodRepository.addFoodList(newFood);
	}
	
	private void clearScreen() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
