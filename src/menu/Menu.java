package menu;

import java.util.ArrayList;

import factory.PayMethodFactory;
import iterator.FoodCollection;
import iterator.ICollection;
import iterator.Iterator;
import models.Food;
import models.PaymentMethod;
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
							"4. Add Payment Method\n" +
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
				break;
			case 3:
				topUpMenu();
				break;
			case 4:
				addPayment();
				break;
			default:
				break;
			}		
		} while (pil != 0);
	}
	
	private void addPayment() {
		PayMethodFactory payMethodFactory = new PayMethodFactory();
		PaymentMethod newPaymentMethod = null;
		int pil = 0;
		do {
			System.out.print(
						"Ay0 m@k4n!!\n" +
						"===========\n" +
						"1. Create AyoPay\n" +
						"2. Create SophiPay\n" +
						"0. Back\n" +
						">> "
					);
			pil = sc.getNum();
			
			switch (pil) {
			case 1: 
				newPaymentMethod = payMethodFactory.addPaymentMethod("AyoPay");
				currUser.setAyoPay(newPaymentMethod);
				sc.showAlert("Successfully made AyoPay!");
				break;
			case 2:
				newPaymentMethod = payMethodFactory.addPaymentMethod("SophiPay");
				currUser.setAyoPay(newPaymentMethod);
				sc.showAlert("Successfully made SophiPay!");
				break;
			case 0:
				break;
			default:
				sc.showAlert("Please Enter [0 - 2]!");
				break;
			}		
		} while (pil != 0);
	}

	private void topUpMenu() {
		if(currUser.getAyoPay() == null && currUser.getSophiPay() == null) {
			sc.showAlert("No Data Found!");
			return;
		}else if(currUser.getAyoPay() == null || currUser.getSophiPay() == null){
			if(currUser.getAyoPay() != null) {
				System.out.println("Your AyoPay Balance : " + currUser.getAyoPay().getBalance());
			}else {
				System.out.println("Your ShopiPay Balance : " + currUser.getSophiPay().getBalance());
			}
		}else {
			System.out.println("Your AyoPay Balance : " + currUser.getAyoPay().getBalance());
			System.out.print("Your ShopiPay Balance : " + currUser.getSophiPay().getBalance());
		}
		String paymentName = "";
		int topUp = 0;
		while(true) {
			System.out.print("Select the payment method that you want to top up [ AyoPay | SophiPay | Cancel ]: ");
			paymentName = sc.getText();
			if(paymentName.equalsIgnoreCase("Cancel")) return;
			else if(paymentName.equalsIgnoreCase("AyoPay")) {
				System.out.print("How much will you top up? ");
				topUp = sc.getNum();
				currUser.getAyoPay().setBalance(topUp);
				sc.showAlert("Successfully top up AyoPay!");
				break;
			}else if(paymentName.equalsIgnoreCase("SophiPay")){
				System.out.print("How much will you top up? ");
				topUp = sc.getNum();
				currUser.getSophiPay().setBalance(topUp);
				sc.showAlert("Successfully top up SophiPay!");
				break;
			}else {
				sc.showAlert("Please Input between [ AyoPay | SophiPay | Cancel ]!");
			}
		}
	}
	
	private void checkBalance() {
		if(currUser.getAyoPay() == null && currUser.getSophiPay() == null) {
			sc.showAlert("No Data Found!");
			return;
		}else if(currUser.getAyoPay() == null || currUser.getSophiPay() == null){
			if(currUser.getAyoPay() != null) {
				System.out.println("Your AyoPay Balance : " + currUser.getAyoPay().getBalance());
			}else {
				System.out.println("Your ShopiPay Balance : " + currUser.getSophiPay().getBalance());
			}
			sc.showAlert("");
		}else {
			System.out.println("Your AyoPay Balance : " + currUser.getAyoPay().getBalance());
			System.out.print("Your ShopiPay Balance : " + currUser.getSophiPay().getBalance());
			sc.showAlert("");
		}
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
		boolean done = false;
		String input = "";
		while(!done) {
			while(true) {
				done = false;
				System.out.print("Please Choose The Menu : ");
				menu = sc.getNum();
				if(menu == 0) return;
				if(menu < 0 || menu > size) sc.showAlert("Please input between [0 - " + size + "]!");
				else {
					done = true;
					break;
				}
			}
			if(done) {
				int quantity = 0;
				while(true) {
					System.out.print("Quantity : "); quantity = sc.getNum();
					if(quantity != 0) break;
				}
				
				System.out.print("Do you want to buy another food? (Y/N) : ");
				input = sc.getText();
				if(input.equalsIgnoreCase("Y")) {
					done = false;
				}else if(input.equalsIgnoreCase("N")){
					break;
				}
			}
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
				editFood();
				break;
			case 2:
				addFood();
				break;
			case 0:
				break;
			default:
				break;
			}		
		} while (pil != 0);
	}
	
	private void addFood() {
		String foodName = "";
		int foodPrice = 0;
		System.out.println("Add Food to The List!");
		
		while(true) {
			System.out.print("Input new food name: ");
			foodName = sc.getText();
			if(!foodName.equals("\n")) break;
		}
		
		while(true) {
			System.out.print("Input new food price: ");
			foodPrice = sc.getNum();
			if(foodPrice != 0) break;
		}
		
		foodRepo.addFoodList(new Food(foodName, foodPrice));
		System.out.printf("Successfully Added New Food! (%s - %d)\n", foodName, foodPrice);
	}
	
	private void editFood() {
		System.out.println("Menu :");
		int size = iterateFood(foodRepo.getFoodList());
		if(size == 0) {
			sc.showAlert("Data not Found!");
			return;
		}
		
		System.out.println("0. Back to Main Menu");
		
		String newFoodName = "";
		int newFoodPrice = 0;
		int pil = 0;
		while(true) {
			System.out.print("What food do you want to edit? [ 0 - " + size + " ]: ");
			pil = sc.getNum();
			
			if(pil == 0) return;
			else if(pil > 0 && pil <= size) break;
			else sc.showAlert("Please Choose Between [ 0 - " + size + " ]!");
		}
		
		while(true) {
			System.out.print("Input new food name: ");
			newFoodName = sc.getText();
			if(!newFoodName.equals("\n")) break;
		}
		
		while(true) {
			System.out.print("Input new food price: ");
			newFoodPrice = sc.getNum();
			if(newFoodPrice != 0) break;
		}
		
		Food currFood = foodRepo.getFoodList().get(pil - 1);
		
		currFood.setFoodName(newFoodName);
		currFood.setFoodPrice(newFoodPrice);
		
		sc.showAlert("Food is successfully edited!");
	}
	
}
