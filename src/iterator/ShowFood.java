package iterator;

import java.util.ArrayList;

import models.Food;
import repository.FoodRepository;

public class ShowFood implements IFood{

	private FoodRepository foodRepo = FoodRepository.getInstance();
	private int curr;
	
	public ShowFood() {
		
	}

	@Override
	public Food getNext() {
		return foodRepo.getFoodList().get(curr);
	}

	@Override
	public boolean hasNext() {
		int size = foodRepo.getFoodList().size();
		return curr < size;
	}

}
