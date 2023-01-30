package state;

import models.Food;

public class FoodOrderCookingState extends FoodOrderState {

	public FoodOrderCookingState(Food food) {
		super(food);
		System.out.println("Food is being Cooked!!");
	}

	@Override
	public void changeState() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		food.setState(new FoodOrderDeliveringState(food));
	}

}
