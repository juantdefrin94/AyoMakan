package state;

import models.FoodCart;

public interface IState {

	public void changeState(State state, FoodCart cart);
	
}
