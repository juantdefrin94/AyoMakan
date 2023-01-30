package state;

import java.util.ArrayList;

import models.FoodCart;
import models.User;

public class State implements IState{

	private IState state;
	
	public void setState(IState state) {
		this.state = state;
	}
	
	public IState getState() {
		return state;
	}

	@Override
	public boolean doState(FoodCart cart, User currUser) {
		
		return false;
	}

}
