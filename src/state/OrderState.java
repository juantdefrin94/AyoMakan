package state;

import models.FoodCart;
import models.User;
import utils.Scan;

public class OrderState implements IState{

	Scan sc = Scan.getInstance();
	
	@Override
	public boolean doState(FoodCart cart, User currUser) {
		//make sure the cart to buy
		System.out.println("Cart :");
		int size = cart.getFoodCart().size();
		int totalFoodPrice = 0;
		for (int i = 0; i < size; i++) {
			String foodName = cart.getFoodCart().get(i).getFoodName();
			int foodPrice = cart.getFoodCart().get(i).getFoodPrice();
			int quantity = cart.getFoodQuantity().get(i);
			System.out.printf("%2d. %s, Quantity : %d\n", i + 1, foodName, quantity);
			System.out.printf("  . Total = %d x %d = %d\n", foodPrice, quantity, (foodPrice * quantity));
			totalFoodPrice += (foodPrice * quantity);
		}
		cart.setFinalPrice(totalFoodPrice);
		System.out.println("Total Price : " + totalFoodPrice);
		String pil = "";
		boolean buy = false;
		while(true) {
			System.out.print("Are you sure want to buy all items in the cart (Y/N)? ");
			pil = sc.getText();
			if(pil.equalsIgnoreCase("Y")) {
				buy = true;
				break;
			}else if(pil.equalsIgnoreCase("N")){
				break;
			}
		}
		if(buy) return true;
		return false;
	}

}
