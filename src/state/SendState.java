package state;

import models.FoodCart;
import models.User;

public class SendState implements IState{

	@Override
	public boolean doState(FoodCart cart, User currUser) {
		cart.setState(new FoodOrderOrderState(cart));
		do{
			cart.getState().changeState();
		}while(!(cart.getState() instanceof FoodOrderDeliveringState));
		return true;
	}

}