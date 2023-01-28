package models;

public class Food {

	private String foodName;
	private Integer foodPrice;
	
	public Food(String foodName, Integer foodPrice) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
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
	

}
