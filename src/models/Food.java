package models;

import state.FoodOrderState;

public class Food {

	private String foodName;
	private Integer foodPrice;
	private FoodOrderState state;
	
	public Food(String foodName, Integer foodPrice, FoodOrderState state) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.state = state;
	}
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	public FoodOrderState getState() {
		return state;
	}

	public void setState(FoodOrderState state) {
		this.state = state;
	}

	

}
