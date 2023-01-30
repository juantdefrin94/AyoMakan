package state;

import models.Food;
import models.FoodCart;

public class FoodOrderOrderState extends FoodOrderState {

	public FoodOrderOrderState(FoodCart cart) {
		super(cart);
		int size = cart.getFoodCart().size();
		for (int i = 0; i < size; i++) {
			System.out.println("Calling the restaurant!");
			System.out.println("Ordering " + cart.getFoodQuantity().get(i) + "x " + cart.getFoodCart().get(i).getFoodName());
			System.out.println("Food has been Ordered!!");
		}
	}

	@Override
	public void changeState() {
		cart.setState(new FoodOrderCookingState(cart));
	}

}
