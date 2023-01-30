package state;

import java.util.ArrayList;

import models.FoodCart;
import models.User;

public interface IState {

	boolean doState(FoodCart cart, User currUser);
	
}
