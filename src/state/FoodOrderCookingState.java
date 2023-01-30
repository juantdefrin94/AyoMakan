package state;

import models.Food;
import models.FoodCart;

public class FoodOrderCookingState extends FoodOrderState {

	public FoodOrderCookingState(FoodCart cart) {
		super(cart);
		int size = cart.getFoodCart().size();
		for (int i = 0; i < size; i++) {
			System.out.println("Your food is being prepared!");
			System.out.println("Chef cooking " + cart.getFoodQuantity().get(i) + "x " + cart.getFoodCart().get(i).getFoodName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Food is being Cooked!!");
		}
	}

	@Override
	public void changeState() {
		cart.setState(new FoodOrderDeliveringState(cart));
	}

}
