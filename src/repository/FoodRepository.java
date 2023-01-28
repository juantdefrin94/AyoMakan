package repository;

import java.util.ArrayList;

import models.Food;

public class FoodRepository {

	public static FoodRepository instance = null;
	private ArrayList<Food>foodList;
	
	private FoodRepository() {
		foodList = new ArrayList<>();
	}
	
	public static FoodRepository getInstance() {
		if(instance == null) {
			instance = new FoodRepository();
		}
		return instance;
	}

	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	public void addUserList(Food newFood) {
		foodList.add(newFood);
	}

}
