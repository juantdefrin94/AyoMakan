package state;

import java.util.ArrayList;

import models.FoodCart;
import models.User;

public class SendState implements IState{

	@Override
	public boolean doState(FoodCart cart, User currUser) {
		return false;
	}

}