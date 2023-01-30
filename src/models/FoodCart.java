package models;

import java.util.ArrayList;

public class FoodCart {

	private ArrayList<Food>foodCart;
	private ArrayList<Integer>foodQuantity;
	private int finalPrice;
	
	public FoodCart() {
		foodCart = new ArrayList<>();
		foodQuantity= new ArrayList<>();
		finalPrice = 0;
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

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	
}
