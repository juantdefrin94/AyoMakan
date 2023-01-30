package state;

import models.Food;
import models.FoodCart;

public abstract class FoodOrderState {
	
	protected FoodCart cart;
	
	public FoodOrderState(FoodCart cart) {
		super();
		this.cart = cart;
	}
	
	public abstract void changeState();
}
