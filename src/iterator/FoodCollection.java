package iterator;

import java.util.ArrayList;

import models.Food;

public class FoodCollection implements ICollection{

	private ArrayList<Food>foodList;
	
	public FoodCollection(ArrayList<Food> foodList) {
		this.foodList = foodList;
	}
	
	@Override
	public Iterator createIterator() {
		FoodIterator food = new FoodIterator();
		return food;
	}
	
	private class FoodIterator implements Iterator{

		private int pos;
		
		@Override
		public boolean hasNext() {
			if(pos < foodList.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object getNext() {
			if(this.hasNext()) {
				return foodList.get(pos++);
			}
			return null;
		}
		
	}

}
