package models;

import java.util.ArrayList;

public class FoodCart {

	private ArrayList<Food>foodCart;
	private ArrayList<Integer>foodQuantity;
	
	public FoodCart() {
		foodCart = new ArrayList<>();
		foodQuantity= new ArrayList<>();
	}

	public ArrayList<Food> getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(ArrayList<Food> foodCart) {
		this.foodCart = foodCart;
	}

	public ArrayList<Integer> getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(ArrayList<Integer> foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	
}
