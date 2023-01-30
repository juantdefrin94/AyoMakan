package state;

import models.Food;

public class FoodOrderDeliveringState extends FoodOrderState {

	public FoodOrderDeliveringState(Food food) {
		super(food);
		System.out.println("Food is Being Delivered!!");
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Food Has Been Delivered!!");
	}

}
