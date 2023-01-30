package state;

import models.Food;

public class FoodOrderOrderState extends FoodOrderState {

	public FoodOrderOrderState(Food food) {
		super(food);
		System.out.println("Food has been Ordered!!");
	}

	@Override
	public void changeState() {
		food.setState(new FoodOrderCookingState(food));
	}

}
