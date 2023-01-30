package state;

import models.Food;
import models.FoodCart;

public class FoodOrderDeliveringState extends FoodOrderState {

	public FoodOrderDeliveringState(FoodCart cart) {
		super(cart);
		int size = cart.getFoodCart().size();
		for (int i = 0; i < size; i++) {
			System.out.println("Driver going to restaurant");
			System.out.println("Driver taking " + cart.getFoodQuantity().get(i) + "x " + cart.getFoodCart().get(i).getFoodName());
			System.out.println("Food has been taken!!");
		}
		System.out.println("Driver going to your house...");
	}

	@Override
	public void changeState() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Food Has Been Delivered!!");
	}

}
