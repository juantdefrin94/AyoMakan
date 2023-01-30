package state;

import models.Food;

public abstract class FoodOrderState {
	
	protected Food food;
	
	public FoodOrderState(Food food) {
		super();
		this.food = food;
	}
	
	public abstract void changeState();
}
